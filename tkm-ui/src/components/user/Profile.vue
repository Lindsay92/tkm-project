<script>
import { useRoute } from 'vue-router';
import { useStore } from "../../plugins/store.js";

export default {
    setup() {   
        const store = useStore();
        const route = useRoute();
        return {
            store,
            route
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
            const response = await this.$axios.get(`/likes/user/all/favorite`);
            this.favorites = response.body;
        },
        async remove(id) {
            const response = await this.$axios.delete(`/likes/delete/${id}`);
            if (response.status === 204) {
                this.$toast.success('toast-global', 'L\'activité a bien été supprimée');
                window.scrollTo(0, 500);
                await this.likeActivities();
            }
            else {
                console.error(response);
                this.$toast.error('toast-global', 'Une erreur s\'est produite.');
            }
        }
    },
    beforeMount() {
        this.likeActivities();
    }
};
</script>
<template>
    <h1 id="top" class="text-center mt-3 mb-5">Mes activités</h1>
        <!-- <div v-if="isAuthenticated && role == 'User'">
            <div class="table-responsive">
                <table class="table table-hover table-sm">
                    <thead>
                        <tr class="text-center align-middle">
                            <th scope="col">Photo</th>
                            <th scope="col">Mon activité favoris</th>
                            <th scope="col">Réservation</th>
                            <th scope="col">Supprimer de ma liste</th>
                        </tr>
                    </thead>
                    <tbody class="text-wrap align-middle text-center table-group-divider">
                        <tr v-for="favorite in favorites" :key="favorite.activityId">
                            <td width="200">
                                <img :src="baseUrl + favorite.activityImageUrl" class="img-fluid w-25"
                                        :alt="favorite.activityName">
                            </td>
                            <td>{{ favorite.activityName }}</td>
                            <td class="text-center">
                                <a v-bind:href="favorite.activityLinkUrl" target="_blank" class="link-title">Réservation
                                </a>
                            </td>
                            <td class="text-center">
                                <a href="#top" @click="remove(favorite.activityId)">
                                    <i class="bi bi-trash3 text-danger"></i>
                                </a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div> -->

        <section class="row">
        <div class="col-12 col-md-4 d-flex justify-content-center fw-semibold text-center" v-for="favorite in favorites" :key="favorite.activityId">
                <div class="card w-100 shadow m-1 fw-normal">          
                    <!-- <img class="img-thumbnail" :src="baseUrl + favorite.activityImageUrl" :alt="favorite.activityName">     -->
                        <div class="d-flex justify-content-end mt-3 me-3" v-if="isAuthenticated && role == 'User'">
                            <!-- <h3>
                                <a href="#top" @click="remove(favorite.activityId)">
                                    <i class="bi bi-trash3 text-danger"></i>
                                </a>
                            </h3> -->
                        </div> 
                    <div class="card-body my-1">
                        <p class="fst-italic text-uppercase"> 
                            <a v-bind:href="favorite.activityLinkUrl" target="_blank" class="link-title">Je réserve</a>
                        </p>
                        <h2 class="activityName">{{ favorite.activityName }}</h2>
                        <h3>
                                <a href="#top" @click="remove(favorite.activityId)">
                                    <i class="bi bi-trash3 text-danger"></i>
                                </a>
                            </h3>  
                    </div>
                </div>
            </div>
        </section>



</template>

