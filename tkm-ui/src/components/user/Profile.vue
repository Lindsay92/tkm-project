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
            const response = await this.$axios.get(`/activities/user/favorite`);
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
    <h1 id="top" class="text-center mt-3 mb-5">Mon carnet de favoris</h1>
        <div v-if="isAuthenticated && role == 'User'">
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
                        <tr v-for="favorite in favorites" :key="favorite.id">
                            <td width="200">
                                <img :src="baseUrl + favorite.imageUrl" class="img-fluid w-25"
                                        :alt="favorite.name">
                            </td>
                            <td>{{ favorite.name }}</td>
                            <td class="text-center">
                                <a v-bind:href="favorite.linkUrl" target="_blank" class="link-title">Réservation
                                </a>
                            </td>
                            <td class="text-center">
                                <a href="#top" @click="remove(favorite.id)">
                                    <i class="bi bi-trash3 text-danger"></i>
                                </a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
</template>