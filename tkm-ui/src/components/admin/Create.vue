<script>
import { useVuelidate } from '@Vuelidate/core';
import { required, maxLength } from "@vuelidate/validators";

export default {
    setup(){
        return{
            validator : useVuelidate({ $autoDirty: true }),
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
                linkUrl: null,
            }
        }
    },
    validations(){
        return {
            inputs: {
                name: { required, maxLength: maxLength(250) },
                description: { required, maxLength: maxLength(1000) },
                imageUrl: { maxValue: (imageUrl) => {
                    return imageUrl === null || imageUrl.size < 512000
                    }
                },
                location: { required, maxlength: maxLength(100) },
                linkUrl: { required, maxLength: maxLength(100) }
            }
        }
    },
    methods: {
        async submit() {
            const valid = await this.validator.$validate();
            if (valid) {
                const formData = new FormData();
                formData.append("name", this.inputs.name);
                formData.append("description", this.inputs.description);
                formData.append("imageUrl", this.inputs.imageUrl);
                formData.append("location", this.inputs.location);
                formData.append("linkUrl", this.inputs.linkUrl);

                try {
                    await this.$axios.post('/activities', formData);
                    Object.assign(this.$data.inputs, this.$options.data().inputs);
                    //console.log(Object.values(formData));
                    this.$router.push('/admin/activities')
                    this.$toast.success('toast-global', this.$t('common.status.success'));
                    window.scrollTo(0, 0);
                } catch (error) {
                    if (error.response.data && error.response.data.messages) {
                        this.$toast.error('toast-global', error.response.data.messages);
                    } else {
                        window.scrollTo(0, 0);
                        this.$toast.error('toast-global', this.$t('common.status.failure'));
                    }
                }
            }
        },
        async fileUpload(event) {
        this.inputs.imageUrl = event.target.files[0]
        }
    }
};
</script>

<template>
    <h1 class="text-center m-5">{{ $t("admin.form.title.new") }}</h1>
    <form novalidate @submit.prevent="submit">
        <div class="row mb-3">
            <div class="col-12">
                <label for="name" class="form-label required">
                    {{ $t("admin.form.name") }}
                </label>
                <input v-model.trim="inputs.name" id="name" name="name" type="text" maxlength="250" class="form-control" :class="{ 'is-invalid': validator.inputs.name.$error }">
                    <span class="invalid-feedback" v-if="validator.inputs.name.$error">
                        <p v-if="validator.inputs.name.required">
                            {{ $t('common.error') }}
                        </p>
                        <p v-if="validator.inputs.name.maxLength">
                            {{ $t('common.error3') }}
                        </p>
                    </span> 
            </div>
        </div>

        <div class="row mb-3">
            <div class="col-12">
                <label for="description" class="form-label required">   
                    {{ $t("admin.form.description") }}
                </label>
                <textarea  v-model.trim="inputs.description" id="description" for="description" name="description" maxlength="1000"  rows="3" class="form-control" :class="{ 'is-invalid': validator.inputs.description.$error }"></textarea>
                    <span class="invalid-feedback" v-if="validator.inputs.description.$error">
                        <p>{{ $t('common.error') }}</p>
                    </span>
            </div>
        </div>

        <div class="row mb-3">
            <div class="col-12">
                <label for="imageUrl" class="form-label required">
                    {{ $t("admin.form.image") }}
                </label>
                <div class="input-group" >
                    <input id="imageUrl" 
                            name="imageUrl" 
                            type="file"
                            accept= "image/png,image/gif,image/jpeg"
                            @change="fileUpload"
                            class="form-control" 
                            :class="{ 'is-invalid': validator.inputs.imageUrl.$error }">
                    <div class="form-text text-danger" v-if="validator.inputs.imageUrl.$error">
                        {{ $t('common.error2') }}
                    </div> 
                </div>
            </div>
        </div>
        
        <div class="row mb-3">
            <div class="col-12">
                <label for="location" class="form-label required">
                    {{ $t("admin.form.location") }}
                </label>
                <input v-model.trim="inputs.location" id="location" name="location" type="text" maxlength="100" class="form-control" :class="{ 'is-invalid': validator.inputs.location.$error }">
                    <span class="invalid-feedback" v-if="validator.inputs.location.$error">
                        <p>{{ $t('common.error') }}</p>
                    </span>
            </div>
        </div>

        <div class="row mb-3">
            <div class="col-12">
                <label for="linkUrl" class="form-label required">
                    {{ $t("admin.form.linkUrl") }}
                </label>
                <div class="input-group">
                    <span class="input-group-text"><i class="bi bi-link"></i></span>
                    <input v-model.trim="inputs.linkUrl" id="linkUrl" name="linkUrl" type="text" maxlength="100"
                    class="form-control" :class="{ 'is-invalid': validator.inputs.linkUrl.$error }">
                        <span class="invalid-feedback" v-if="validator.inputs.linkUrl.$error">
                            <p>{{ $t('common.error') }}</p>
                        </span>
                </div>
            </div>
        </div>

        <div class="d-grid d-md-flex justify-content-md-end mb-3">
            <button type="submit" class="btn btn-dark" :disabled="validator.$invalid">
                {{ $t("admin.form.send") }}
            </button>
        </div>
        <div class="d-md-flex justify-content-md-end mb-3">
            <button class="btn btn-dark">
                <router-link :to="{ name: 'activities-edit' }" class="text-decoration-none link text-light">
                    {{ $t("admin.form.back") }}
                </router-link>
            </button>
        </div>
    </form>
</template>