<script>
export default {
    data() {
        return {
            baseUrl: import.meta.env.VITE_IMG_BASE_URL,
            isAuthenticated : localStorage.getItem("isAuthenticated"),
            role : localStorage.getItem("role"),
            userName : localStorage.getItem("userName"),
            activities: [],
        }
    },
    
    methods: {
        async initActivities() {
            const response = await this.$axios.get('/activities');
            this.activities = response.data.map(activity => ({
                ...activity, 
                isFavorite: false
        }))
    },
        async toggleFavorite(id) {
            try {
                const response = await this.$axios.post(`/likes/${id}`);
                if (response && response.status === 204) {
                    const activity = this.activities.find(activity => activity.id === id);
                    if (activity) {
                        activity.isFavorite = !activity.isFavorite;
                    }
                }
            } catch(error) {
            console.log("erreur");
            }
        }
    },
    beforeMount() {
        this.initActivities();
    }
};
</script>

<template>
    <h1 id="top" class="text-center m-5">Activités et Restaurants/Marchés</h1>

        <section class="m-5">
            <div class="input-group">
                <span class="input-group-text" id="basic-addon1">Filtrer</span>
                <input type="text" class="form-control"> <!--v-model="inputFilter"-->
            </div>
        </section>
        <section class="row">
            <div class="col-12 col-md-4 d-flex justify-content-center fw-semibold text-center" v-for="activity in activities" :key="activity.id">
                <div class="card w-100 shadow m-1 fw-normal">          
                    <img class="img-thumbnail" :src="baseUrl + activity.imageUrl" :alt="activity.name">    
                        <div class="d-flex justify-content-end mt-3 me-3" v-if="isAuthenticated && role == 'User'">
                            <span @click="toggleFavorite(activity.id)" class="favorite-icon">
                                <i v-if="activity.isFavorite" class="bi bi-heart-fill"></i>
                                <i v-else class="bi bi-heart pointer"></i>
                            </span>
                        </div> 

                    <div class="card-body my-1">
                        <h2 class="activityName">{{ activity.name }}</h2>
                        <p>{{ activity.location}}</p>
                        <p class="fst-italic text-uppercase"> 
                            <a v-bind:href="activity.linkUrl" target="_blank" class="link-title">Réservation</a>
                        </p>  
                            <div v-if="isAuthenticated && role == 'User'">
                                <p class=" mb-3">
                                    <router-link :to=" { name: 'user-activity-detail', params: { id: activity.id } }" class="link"><span >Plus d'info </span> 
                                        <i class="bi bi-box-arrow-up-right"></i>
                                    </router-link>
                                </p>  
                            </div>
                            <div v-else>
                                <p class=" mb-3">
                                    <router-link :to=" { name: 'activity-detail', params: { id: activity.id } }" class="link"><span >Plus d'info </span> 
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
                    <span class="btnColor" id="scrollUp">
                        <a href="#top"><img src="src/assets/arrow-up-circle.svg"/></a>
                    </span>
                </div>
            </div>
</template>

<style>
.pointer {
  cursor: pointer;
}

.text-danger {
    color: red;
}

</style>