<script>
import { RouterLink } from 'vue-router';

export default {
    data() {
        return {
            homeActivities: []
        }
    },
    async beforeMount() {
        const response = await fetch('/data/homeActivities.json');
        this.homeActivities = await response.json();
    }
}
</script>

<template>
    <h1 class="text-center m-5">La Guyane Française, un pays au mille visages !</h1>

    <p class="text-center slogan m-3 "> <span class="medium">Tout Koulèr Mélanjé</span> est une application qui fait référence à la diversité du territoire guyanais. Un pays pluriculturel où se mélange différentes communautés telles que des Amérindiens, des Hmongs, des Brésiliens, des Guyanais, des Businengés... 
        <br>
    Ce pays méconnu et ayant parfois une mauvaise réputation se révèle comme une terre accueillante et offrant une expérience exceptionnelle et mémorable.  
        <br>
        <br>
    Que vous soyez seul(e), en famille ou entre ami(e)s, <span class="medium">Tout Koulèr Mélanjé</span> a pour objectif de vous faire découvrir ou redécouvrir la richesse de la Guyane Française à travers différentes activités ou enore par la gastronomie guyanaise. 
        <br>
        <br>
    Ajouter dans votre carnet de voyage les activités souhaitées et partager vos expériences inoubliables entre abonnés. </p>

    <div class="m-4">
        <p class="text-center fs-5 fw-bold activity-list"><RouterLink to="/activities" class="link-title"> "Accéder aux activités et les restaurants"</RouterLink>
        </p>
    </div>

        <section class=" row fw-semibold text-center m-4">
            <div class="col-12 col-md-4 p-3 d-flex justify-content-center" v-for="activity in homeActivities" :key="activity.id">
                <!--children of the same common parent must have unique key-->

                <div class="card w-100 shadow">
                    <RouterLink to="/activities" class="link-title">
                        <img v-bind:src= "activity.imageUrl" class="card-img-top" :alt= "activity.alt">
                    </RouterLink>
                    <div class="card-body">
                        <h2 class="activityName">{{ activity.title }}</h2>
                        <p class="card-text">{{ activity.prez }}</p>
                    </div>
                </div>
            </div>
        </section>
</template>