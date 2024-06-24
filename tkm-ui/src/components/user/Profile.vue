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
                this.$toast.success('toast-global', this.$t('common.status.done'));
                this.likeActivities();
                window.scrollTo(0, 500);
            }
            else {
                this.$toast.error('toast-global', this.$t('common.status.failure'));
            }
        }
    },
    beforeMount() {
        this.likeActivities();
    }
}
</script>

<template>
    <h1 id="top" class="text-center mt-3 mb-5">
        {{ $t("profil.title") }}
    </h1>
        <section class="row">
        <div class="col-12 col-md-4 d-flex justify-content-center fw-semibold text-center" v-for="favorite in favorites" :key="favorite.activityId">
                <div class="card w-100 shadow m-1 fw-normal">          
                    <img class="img-thumbnail" :src="baseUrl + favorite.activityImageUrl" :alt="favorite.activityName">    
                        <div class="d-flex justify-content-end mt-3 me-3" v-if="isAuthenticated && role == 'User'">
                        </div> 
                    <div class="card-body my-1">
                        <h2 class="activityName">{{ favorite.activityName }}</h2>
                        <p class="fst-italic text-uppercase"> 
                            <a v-bind:href="favorite.activityLinkUrl" target="_blank" class="link-title">
                                {{ $t("profil.link") }}
                            </a>
                        </p>
                        <span class="d-flex justify-content-end">
                                <a href="#top" @click="remove(favorite.activityId)">
                                    <i class="bi bi-trash3 text-danger"></i>
                                </a>
                        </span>  
                    </div>
                </div>
            </div>
        </section>
</template>

