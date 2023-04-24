<script>
export default {
    data() {
        return {
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
    <h1 class="text-center m-5">Les activités et restaurants proposés</h1>

            <section class="m-5">
                <div class="input-group">
                    <span class="input-group-text" id="basic-addon1">Filtrer</span>
                    <input type="text" class="form-control">
                </div>
            </section>

            <div v-for="activity in activities">
                Test : {{ activity.name }}
            </div>
                
            <section class="row ">
                <div class="col-12 col-md-4 d-flex justify-content-center fw-semibold text-center" v-for="activity in activities">
                    <!-- TEST <img src="src/assets/images/accueilImage/forest.jpg">  -->
                    <div class="card w-100 shadow m-1 fw-normal">
                        <img src="src/assets/images/accueilImage/forest.jpg">   
                        <!--VOIR COMMENT CHARGER IMAGES-->               
                            <!-- <img :src="activity.imageUrl" :alt="sticker.name">                    -->
                            
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

                                <a href=""><img src="src/assets/images/heart.svg" title="Ajouter à mon carnet"></a>
                            </div>
                    </div>

                </div>
            </section>

                <div class="row">
                    <div class="d-flex justify-content-end p-4">
                        <span class="btnColor" id="scrollUp">
                            <a href="#top"><img src="src/assets/images/arrow-up-circle.svg"/></a>
                        </span>
                    </div>
                </div>

</template>