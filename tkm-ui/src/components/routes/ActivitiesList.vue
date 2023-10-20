<script>
export default {
    data() {
        return {
            baseUrl: import.meta.env.VITE_IMG_BASE_URL,
            activities: [],
        }
    },
    
    methods: {
        async initActivities() {
            const response = await this.$axios.get('/activities');
            this.activities = response.body;
        }
    },
    beforeMount() {
        this.initActivities();
    }
};
</script>

<template>
    <h1 class="text-center m-5">Activités et Restaurants/Marchés</h1>

        <section class="m-5">
            <div class="input-group">
                <span class="input-group-text" id="basic-addon1">Filtrer</span>
                <input type="text" class="form-control" v-model="inputFilter">
            </div>
        </section>
                
        <section class="row">
            <div class="col-12 col-md-4 d-flex justify-content-center fw-semibold text-center" v-for="activity in activities" :key="activity.id">
                <div class="card w-100 shadow m-1 fw-normal">          
                    <img :src="baseUrl + activity.imageUrl" :alt="activity.name">                   
                            
                    <div class="card-body my-1">
                        <h2>{{ activity.name }}</h2>
                            <div>
                                <p>{{ activity.location}}</p>
                            </div>
                            <div>
                                <p class="fst-italic text-uppercase"> 
                                    <a v-bind:href="activity.linkUrl" target="_blank" class="link-title">Accès au site</a>
                                </p>
                            </div>
                            <a href="" class="link"><i class="bi bi-suit-heart" title="Ajouter à mon carnet"></i></a>
                    </div>

                    <p class=" mb-3">
                        <RouterLink :to=" { name: 'activity-detail', params: { id: activity.id } }" class="link"><span >Détail et localisation</span> 
                            <i class="bi bi-box-arrow-up-right"></i>
                        </RouterLink>
                    </p>
                
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