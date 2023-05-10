<script>
import { useVuelidate } from '@Vuelidate/core';
import { required, maxLength } from "@vuelidate/validators";

export default {
    setup(){
        return{
            validator : useVuelidate(),
        }
    },
    data(){
        return {
            baseUrl: import.meta.env.VITE_IMG_BASE_URL,
            inputs: {
                name: null,
                description: null,
                imageUrl: null,
                location: null,
                lien: null,
            }
        }
    },
    validations(){
        return {
            inputs: {
                name: { required, maxLength: maxLength(100) },
                description: { required, maxLength: maxLength(1000) },
                imageUrl: { required, maxLength: maxLength(100) },
                location: { required, maxlength: maxLength(100) },
                linkUrl: { required, maxLength: maxLength(100) }
            }
        }
    },
    methods: {
        async submit() {
            const response = await this.validator.$validate();
            if (response) {
                this.$axios.post('/activities', this.inputs);
                Object.assign(this.$data.inputs, this.$options.data().inputs);
                this.validator.$reset();
            } else {
                console.log('erreur')
            }

        },
    }

};
</script>

<template>
    <h1 class="mt-3">Create a new activity</h1>
    <form novalidate @submit.prevent="submit">
        <div class="row mb-3">
            <div class="col-12">
                <label for="name" class="form-label required">Name</label>
                <input v-model.trim="inputs.name" id="name" name="name" type="text" maxlength="250" class="form-control" :class="{ 'is-invalid': validator.inputs.name.$error }">
            </div>
        </div>

        <div class="row mb-3">
            <div class="col-12">
                <label for="description" class="form-label required">Description</label>
                <textarea  v-model.trim="inputs.description" id="description" for="description" name="description" maxlength="1000"  rows="3" class="form-control" :class="{ 'is-invalid': validator.inputs.description.$error}"></textarea>
            </div>
        </div>

        <div class="row mb-3">
            <div class="col-12">
                <label for="imageUrl" class="form-label required">Image</label>
                <div class="input-group">
                    <span class="input-group-text">Image url</span>
                    <input v-model.trim="inputs.imageUrl" id="imageUrl" name="imageUrl" type="text" maxlength="100"
                        class="form-control" :class="{ 'is-invalid': validator.inputs.imageUrl.$error }">
                </div>
            </div>
        </div>
        
        
        <div class="row mb-3">
            <div class="col-12">
                <label for="location" class="form-label required">Location</label>
                <input v-model.trim="inputs.location" id="location" name="location" type="text" maxlength="100" class="form-control" :class="{ 'is-invalid': validator.inputs.location.$error }">
            </div>
        </div>

        <div class="row mb-3">
            <div class="col-12">
                <label for="linkUrl" class="form-label required">Lien</label>
                <div class="input-group">
                    <span class="input-group-text">Lien url</span>
                    <input v-model.trim="inputs.linkUrl" id="linkUrl" name="linkUrl" type="text" maxlength="100"
                        class="form-control" :class="{ 'is-invalid': validator.inputs.linkUrl.$error }">
                </div>
            </div>
        </div>

        <div class="d-grid d-md-flex justify-content-md-end mb-3">
            <button type="submit" class="btn btn-dark" :disabled="validator.$invalid">Envoyer</button>
        </div>
    </form>
</template>