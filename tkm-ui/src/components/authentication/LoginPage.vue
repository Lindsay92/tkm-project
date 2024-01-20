<script>
import { RouterLink } from 'vue-router';
import { useVuelidate } from '@Vuelidate/core';
import { required, maxLength, minLength, helpers, email } from '@vuelidate/validators';

export default {
    setup() {
        return {
            validator : useVuelidate({ $autoDirty: true }),
        }
    },
    data() {
        return {
            inputs: {
                email: null,
                password: null
            }
        }
    },
    validations() {
        return {
            inputs: {
                email: { 
                    required,
                    email
                },
                password: { 
                    required,
                    minLength: minLength(8), 
                    maxLength: maxLength(42),
                    pattern: helpers.regex(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@||%||!||*])(?!.* ).{8,42}/)
                }
            }
        }
    },
    methods: {
        async submitForm() {
            const valid = await this.validator.$validate();
            if (valid) {
                const response = await this.$axios.post('/sign-in', this.inputs);
                //console.log(response);
                    if (response) {
                        Object.assign(this.inputs, this.$options.data().inputs);
                        if (response.body.role.includes("Administrator")){
                            // this.validator.$reset();
                            this.$router.push('admin/activities')
                        } else if (response.body.role.includes("User")) {
                            this.$router.push("/user/activities");
                        } else {
                            // console.log("error");
                            this.$toast.error('toast-global', 'Une erreur s\'est produite.');
                        }
                    }  
            }               
        }
    }
}
</script>

<template>
    <div class="row m-3">
        <div class="d-flex justify-content-center align-items-center">
            <section class="frame row flex-fill me-4">
                <form novalidate @submit.prevent="submitForm" class=" border border-dark rounded">
                    <legend>Se connecter</legend>
                    <div class="mb-3">
                        <label for="email" class="form-label required">Email*</label>
                        <input
                            v-model.trim="inputs.email"  
                            type="email" 
                            name="email"
                            id="email"
                            class="form-control"
                            :class="{ 'is-invalid': validator.inputs.email.$error }" >
                            <span class="invalid-feedback" v-if="validator.inputs.email.$error">
                                <p>Le champ est obligatoire</p>
                            </span> 
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label required">Mot de passe*</label>
                        <input 
                            v-model.trim="inputs.password" 
                            type="password"
                            name="password"
                            id="password"
                            class="form-control"
                            :class="{ 'is-invalid': validator.inputs.password.$error }">
                                <span class="invalid-feedback" v-if="validator.inputs.password.$error">
                                    <p>Le mot de passe doit être entre 8 - 42 caractères avec au moins une majuscule, au moins un chiffre et un caractère spécial @%*!</p>
                                </span>
                    </div>
                    <div class="d-flex justify-content-end">
                        <button type="submit" class="btn btn-outline-dark mb-3 mt-3 text-white" :disabled="validator.$invalid">Se connecter</button>
                    </div>

                    <p class="text-center m-3">
                        <router-link to= "/auth" class="link">Si vous n’avez pas de compte, cliquez sur le lien</router-link>
                    </p>   
                </form>
            </section>
            <section class="col-md-6">
                <img src="/images/jaguar.jpg" class="loginImage rounded-4" alt="Image d'un jaguar">
            </section>
        </div>
    </div>
</template>