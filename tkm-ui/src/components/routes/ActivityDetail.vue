<script>
import { useRoute } from 'vue-router';

export default {
    setup() {
        return {
            route: useRoute()
        }
    },
    data() {
        return {
            id: this.route.params.id,
            baseUrl: import.meta.env.VITE_IMG_BASE_URL,
            activity: {}
        }
    },
    methods: {
        async initActivity() {
            const response = await this.$axios.get(`/activities/${this.id}/detail`);
            this.activity = response.body;
        }
    },
    beforeMount() {
        this.initActivity();
    }
}
</script>

<template>

    <h1 class="text-center m-3">{{ activity.name }}</h1>
    
    <section class="row text-center">
        <div class="col-12 col-md-6 my-3 align-items-center justify-content-center">
            <img :src="baseUrl + activity.imageUrl" class="img-fluid w-75" :alt="activity.name">
        </div>

        <div
            class="col-12 col-md-6 my-3 align-items-center justify-content-center fs-5">{{ activity.description }}
        </div>
    </section>

    <div class="fst-italic m-2 text-center fs-5">
        <p> 
            <a v-bind:href="activity.linkUrl" target="_blank" class="link-title">Pour accèder au site du prestataire, cliquez-ici <i class="bi bi-box-arrow-up-right"></i></a> 
        </p>
        <p> 
            <a href="" class="link"><span >Localisation</span> <i class="bi bi-geo-alt"></i></a>
        </p>
    </div>

    <div class="text-end">
        <button class="btn btn-dark">
            <RouterLink :to="{name: 'activities'}" class="text-decoration-none link text-light">Retour à la liste</RouterLink>
        </button>
    </div>

</template>