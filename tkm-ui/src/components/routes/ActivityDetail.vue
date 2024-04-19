<script>
import { useRoute } from 'vue-router';

export default {
    setup() {
        const key = import.meta.env.VITE_MAPS_EMBED_API_KEY;
        return {
            route: useRoute(),
            isAuthenticated : localStorage.getItem("isAuthenticated"),
            role : localStorage.getItem("role"),
            userName : localStorage.getItem("userName"),
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
            <img :src="baseUrl + activity.imageUrl" class="img-fluid w-75 rounded border border-5" :alt="activity.name">
        </div>
    </section>

    <section class="row d-flex align-items-center justify-content-center text-center">
        <div class="col-12 col-md-6 fst-italic fw-bold fs-5 mt-5 mb-5">
            <a v-bind:href="activity.linkUrl" target="_blank" class="link-title fst-italic text-uppercase">Réservation <i class="bi bi-box-arrow-up-right"></i></a>
        </div>
        <div class="col-12 col-md-6" v-if="isAuthenticated && role == 'User'">
            <button class="btn btn-dark btn-lg">
                <router-link :to="{name: 'user-activities'}" class="text-decoration-none link text-light"
                href="#top">Retour à la liste</router-link>
            </button>
        </div>
        <div class="col-12 col-md-6" v-else>
            <button class="btn btn-dark btn-lg">
                <router-link :to="{name: 'activities'}" class="text-decoration-none link text-light"
                href="#top">Retour à la liste</router-link>
            </button>
        </div>
    </section>





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

    <!-- <div class="text-end" v-if="isAuthenticated && role == 'User'">
        <button class="btn btn-dark">
            <router-link :to="{name: 'user-activities'}" class="text-decoration-none link text-light"
            href="#top">Retour à la liste</router-link>
        </button>
    </div>
    <div v-else>
        <button class="btn btn-dark">
            <router-link :to="{name: 'activities'}" class="text-decoration-none link text-light"
            href="#top">Retour à la liste</router-link>
        </button>
    </div> -->

</template>