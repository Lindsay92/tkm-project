<script>
import { useStore } from '../../plugins/store.js';

export default {
    setup() {
    const store = useStore(); 
    return { store };  
    },
    data() {
        return {
            baseUrl: import.meta.env.VITE_IMG_BASE_URL,
            isAuthenticated : localStorage.getItem("isAuthenticated"),
            role : localStorage.getItem("role"),
            userName : localStorage.getItem("userName"),
            activities: []
        }
    },
    
    methods: {
        async initActivities() {
            const response = await this.$axios.get('/activities');
            this.activities = response.data.map(activity => ({
                ...activity, 
                isFavorite: this.store.isFavorite(activity.id)
            }));
        },
        async toggleFavorite(id) {
            try {
                const response = await this.$axios.post(`/likes/${id}`);
                if (response && response.status === 204) {
                    if (!this.store.isFavorite(activity)) {
                        this.store.addFavorite(activty);
                    } else  {
                        this.store.removeFavorite(activity)
                    }                   
                    this.initActivities();
                    console.log(response);
                } 
            } catch(error) {
            window.scrollTo(0, 500);
            this.$toast.error('toast-global', this.$t("common.status.favory"));
            }
        }
    },
    beforeMount() {
        this.initActivities();
    }
}
</script>

<template>
    <h1 id="top" class="text-center m-5">
        {{ $t('activities.title') }}
    </h1>

    <!-- {{ activities }} -->
        <section class="m-5">
            <div class="input-group">
                <span class="input-group-text" id="basic-addon1">
                    {{ $t('activities.filter') }}
                </span>
                <input type="text" class="form-control"> <!--v-model="inputFilter"-->
            </div>
        </section>
        <section class="row">
            <div class="col-12 col-md-4 d-flex justify-content-center fw-semibold text-center" v-for="activity in activities" :key="activity.id">
                <div class="card w-100 shadow m-1 fw-normal">          
                    <img class="img-thumbnail" :src="baseUrl + activity.imageUrl" :alt="activity.name">    
                        <div class="d-flex justify-content-end mt-3 me-3" v-if="isAuthenticated && role == 'User'">
                            <h2 @click="toggleFavorite(activity.id)" class="favorite-icon">
                                <i v-if="store.isFavorite(activity.id)" class="bi bi-heart-fill"></i>
                                <i v-else class="bi bi-heart  pointer"></i>
                            </h2>
                        </div> 

                    <div class="card-body my-1">
                        <h2 class="activityName">{{ activity.name }}</h2>
                        <p>{{ activity.location}}</p>
                        <p class="fst-italic text-uppercase"> 
                            <a v-bind:href="activity.linkUrl" target="_blank" class="link-title">
                                {{ $t('activities.reservation') }}
                            </a>
                        </p>  
                            <div v-if="isAuthenticated && role == 'User'">
                                <p class=" mb-3">
                                    <router-link :to=" { name: 'user-activity-detail', params: { id: activity.id } }" class="link">
                                        <span>
                                            {{ $t('activities.info') }} 
                                        </span> 
                                        <i class="bi bi-box-arrow-up-right"></i>
                                    </router-link>
                                </p>  
                            </div>
                            <div v-else>
                                <p class=" mb-3">
                                    <router-link :to=" { name: 'activity-detail', params: { id: activity.id } }" class="link">
                                        <span>
                                            {{ $t('activities.info') }}
                                        </span> <br>
                                        <i class="bi bi-box-arrow-up-right"></i>
                                    </router-link>
                                </p>  
                            </div>
                    </div>
                </div>
            </div>
        </section>

            <div class="row">
                <div class="d-flex justify-content-end p-4">
                    <h2 class="btnColor" id="scrollUp">
                        <a href="#top"><i class="bi bi-arrow-up-circle text-dark"></i></a>
                    </h2>
                </div>
            </div>
</template>

<style>
.pointer {
    cursor: pointer;
}
</style>