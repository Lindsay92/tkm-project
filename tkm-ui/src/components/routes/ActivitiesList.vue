<script>
export default {
    data() {
        return {
            baseUrl: import.meta.env.VITE_IMG_BASE_URL,
            activities: []
        }
    },
    methods: {
        async initActivities() {
            const response = await this.$axios.get('/activities');
            this.activities = response.data;
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
                    <input type="text" class="form-control">
                </div>
            </section>

            <!-- <div v-for="activity in activities">
                Test : {{ activity.name }}
            </div> -->
                
            <section class="row ">
                <div class="col-12 col-md-4 d-flex justify-content-center fw-semibold text-center" v-for="activity in activities">
                    <div class="card w-100 shadow m-1 fw-normal">          
                            <img :src="baseUrl + activity.imageUrl" :alt="activity.name">                   
                            
                            <div class="card-body my-1">
                                <h2>{{ activity.name }}</h2>
                                <p class="card-text">{{ activity.description}}</p>
                                <div>
                                    <p>{{ activity.location}}</p>
                                </div>
                                <div>
                                    <p class="fst-italic text-uppercase"> 
                                        <a v-bind:href="activity.linkUrl" target="_blank" class="link-title">Accès au site</a>
                                    </p>
                                </div>
                                <a href=""><img src="src/assets/heart.svg" title="Ajouter à mon carnet"></a>
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