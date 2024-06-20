<script>
import { RouterLink } from 'vue-router';
import { useVuelidate } from '@vuelidate/core';
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
                    if (response) {
                        Object.assign(this.inputs, this.$options.data().inputs);
                        if (response.body.role.includes("Administrator")){
                            this.$router.push('admin/activities')
                        } else if (response.body.role.includes("User")) {
                            this.$router.push("/user/all/favorite");
                        } else {
                            window.scrollTo(0, 0);
                            this.$toast.error('toast-global', this.$t("common.status.failure"));
                        }
                    }  
            }               
        }
    }
}
</script>

<template>
    <div class="row m-5">
        <div class="d-flex justify-content-center align-items-center">
            <section class="frame row flex-fill me-4">
                <form novalidate @submit.prevent="submitForm" class=" border border-dark rounded">
                    <legend>{{ $t('formLogin.connect') }}</legend>
                    <div class="mb-3">
                        <label for="email" class="form-label required">
                            {{ $t('formLogin.email') }}*
                        </label>
                        <input
                            v-model.trim="inputs.email"  
                            type="email" 
                            name="email"
                            id="email"
                            class="form-control"
                            :class="{ 'is-invalid': validator.inputs.email.$error }" >
                            <span class="invalid-feedback" v-if="validator.inputs.email.$error">
                                <p>{{ $t('common.error') }}</p>
                            </span> 
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label required">{{ $t('formLogin.password') }}*</label>
                        <input 
                            v-model.trim="inputs.password" 
                            type="password"
                            name="password"
                            id="password"
                            class="form-control"
                            :class="{ 'is-invalid': validator.inputs.password.$error }">
                                <span class="invalid-feedback" v-if="validator.inputs.password.$error">
                                    <p>{{ $t('common.error') }}</p>
                                </span>
                    </div>
                    <div class="d-flex justify-content-end">
                        <button type="submit" class="btn btn-outline-dark mb-3 mt-3" :disabled="validator.$invalid">
                            {{ $t('formLogin.connect') }}
                        </button>
                    </div>

                    <p class="text-center m-3">
                        <router-link to= "/auth" class="link">
                            {{ $t('formLogin.linkAuth') }}
                        </router-link>
                    </p>   
                </form>
            </section>
            <section class="col-md-6">
                <img src="/images/jaguar.jpg" class="loginImage rounded-4" alt="Image d'un jaguar">
            </section>
        </div>
    </div>
</template>