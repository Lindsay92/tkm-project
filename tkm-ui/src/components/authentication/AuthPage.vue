<script>
import { useVuelidate } from '@Vuelidate/core';
import { required, maxLength, minLength, helpers, email } from '@vuelidate/validators';

export default {
    setup(){
        return {
            validator : useVuelidate({ $autoDirty: true }),
        }
    },
    data() {
        return{
            inputs: {
                firstName: null,
                lastName: null,
                email: null,
                password: null
            }
        }
    },
    validations() {
        return {
            inputs: {
                firstName: { 
                    required,
                    pattern: helpers.regex(/^[a-zA-Z-éàâèêôûîç'’ ]+$/) 
                },
                lastName: { 
                    required,
                    pattern: helpers.regex(/^[a-zA-Z-éàâèêôûîç'’ ]+$/) 
                },
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
            const response =  await this.$axios.post('/sign-up', this.inputs);
            if (response) {
                Object.assign(this.inputs, this.$options.data().inputs);
                this.validator.$reset();
                this.$router.push('login');
            } else {
                window.scrollTo(0, 0);
                this.$toast.error('toast-global', this.$t("common.status.failure"));
            }
        }
    }
}
</script>

<template>
    <section class="row  m-5">
        <div class="d-flex justify-content-center">
            <form novalidate @submit.prevent="submitForm" class=" col-md-6">
                <legend>{{ $t('formAuth.create') }}</legend>
                <div class="mb-3">
                    <label for="firstName" class="form-label required">{{ $t('formAuth.firstName') }}*</label>
                    <input 
                        v-model.trim="inputs.firstName" 
                        id="firstName" 
                        name="firstName" 
                        type="text"  
                        class="form-control" 
                        :class="{ 'is-invalid': validator.inputs.firstName.$error }">
                            <span class="invalid-feedback" v-if="validator.inputs.firstName.$error">
                                <p>{{ $t('common.error') }}</p>
                            </span> 
                </div>
                <div class="mb-3">
                    <label for="lastName" class="form-label">
                        {{ $t('formAuth.name') }}*
                    </label>
                    <input 
                        v-model.trim="inputs.lastName" 
                        name="lastName"
                        type="text"
                        id="lastName" 
                        class="form-control" 
                        :class="{ 'is-invalid': validator.inputs.lastName.$error }" >
                            <span class="invalid-feedback" v-if="validator.inputs.lastName.$error">
                                <p>{{ $t('common.error') }}</p>
                            </span> 
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">
                        {{ $t('formAuth.email') }}*
                    </label>
                    <input 
                        v-model.trim="inputs.email" 
                        type="email"
                        name="email"
                        id="email" 
                        class="form-control" 
                        :class="{ 'is-invalid': validator.inputs.email.$error }">
                            <span class="invalid-feedback" v-if="validator.inputs.email.$error">
                                <p>{{ $t('common.error') }}</p>
                            </span> 
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">
                        {{ $t('formAuth.password') }}*
                    </label>
                    <input 
                        v-model.trim="inputs.password" 
                        type="password" 
                        name="password"
                        id="password" 
                        class="form-control" 
                        :class="{ 'is-invalid': validator.inputs.password.$error }">
                            <span class="invalid-feedback" v-if="validator.inputs.password.$error">
                                <p>{{ $t('common.error1') }}</p>
                            </span> 
                </div>
                <div class="d-flex justify-content-end">
                    <button type="submit" class="btn btn-outline-dark mt-3 mb-3 ":disabled="validator.$invalid">{{ $t('formAuth.create') }}</button>
                </div>  
            </form>
        </div>
    </section>
</template>