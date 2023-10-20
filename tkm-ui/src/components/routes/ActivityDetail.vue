<script>
import { useRoute } from 'vue-router';

export default {
    setup() {
        const key = import.meta.env.VITE_MAPS_EMBED_API_KEY;
        return {
            route: useRoute(),
            mapsUrl: `https://www.google.com/maps/embed/v1/place?key=${key}`
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

    <h1 class="text-center mt-3 mb-5">{{ activity.name }}</h1>
    
    <section class="row d-flex align-items-center justify-content-center text-center my-3">
        <div
            class="col-12 col-md-6">{{ activity.description }}
        </div>
        <div class="col-12 col-md-6">
            <img :src="baseUrl + activity.imageUrl" class="img-fluid w-100 rounded border border-5" :alt="activity.name">
        </div>
    </section>

    <div class="fst-italic fs-5 mt-5 mb-5 text-center">
        <p> 
            <a v-bind:href="activity.linkUrl" target="_blank" class="link-title fst-italic text-uppercase">Réservation <i class="bi bi-box-arrow-up-right"></i></a> 
        </p>
    </div>

    <h2 class="text-center">Localisation de votre activité</h2>
    
    <section class="col-12 mb-5">
        <div class="ratio ratio-16x9 border rounded-2 shadow-sm w-75 mx-auto">
            <iframe loading="lazy" 
                    frameborder="0" 
                    referrerpolicy="no-referrer-when-downgrade"
                    allowfullscreen  
                    :src="mapsUrl + `&q=${activity.name},Cayenne+Guyane&language=fr`" 
                    title="Carte de géolocalisation">
            </iframe>
        </div>
    </section>

    <div class="text-end">
        <button class="btn btn-dark">
            <RouterLink :to="{name: 'activities'}" class="text-decoration-none link text-light">Retour à la liste</RouterLink>
        </button>
    </div>

</template>