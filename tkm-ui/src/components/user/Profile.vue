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
            baseUrl: import.meta.env.VITE_IMG_BASE_URL,
            isAuthenticated : localStorage.getItem("isAuthenticated"),
            role : localStorage.getItem("role"),
            userName : localStorage.getItem("userName"),
            id: this.route.params.id,
            favorites: {}
        }
    },
    
    methods: {
        async likeActivities() {
            const response = await this.$axios.get(`/activities/user/favorite`);
            this.favorites = response.body;
        }
    },
    beforeMount() {
        this.likeActivities();
    }
};
</script>
<template>
    <h1 class="text-center mt-3 mb-5">Mon carnet de favoris</h1>
    <div v-if="isAuthenticated && role == 'User'">
        <div class="row">
            <div class="col-12 col-md-3 d-flex justify-content-center fw-semibold text-center" v-for="favorite in favorites" :key="favorite.id">
                <!-- <div v-for="favoriteActivities in favorite.favoriteActivities" :key="favoriteActivities.id"> -->
                <div class="card w-100 shadow m-1 fw-normal">          
                    <img class="img-thumbnail" :src="baseUrl + favorite.imageUrl" :alt="favorite.name"> 
                        <div class="card-body my-1">
                            <h2 class="activityName">{{ favorite.name }}</h2>
                            <p>{{ favorite.location}}</p>
                            <p class="fst-italic text-uppercase"> 
                                <a v-bind:href="favorite.linkUrl" target="_blank" class="link-title">Réservation</a>
                            </p>          
                        </div>
                </div>
            </div>
        </div>
    </div>
</template>

 <!-- <div v-if="isAuthenticated && role == 'User'">
                                        <p class=" mb-3">
                                            <router-link :to=" { name: 'user-activity-detail', params: { id: favoriteActivities.id } }" class="link"><span >Plus d'info </span> 
                                                <i class="bi bi-box-arrow-up-right"></i>
                                            </router-link>
                                        </p>  
                                    </div> -->