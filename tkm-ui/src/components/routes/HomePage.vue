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

    <p class="text-center slogan m-3 "> <span class="medium">Tout Koulèr Mélanjé</span> est une application qui fait référence à la diversité du territoire guyanais. Un pays pluriculturel où se mélange différentes communautés (des Amérindiens, des Hmongs, des Brésiliens, des Chinois, des Guyanais, des Businengés…). <br>
    Ce pays méconnu et ayant parfois une mauvaise réputation se révèle comme une terre accueillante offrant une expérience exceptionnelle et mémorable. <br>
    <br>Que vous soyez seul, en famille ou entre amis, <span class="medium">Tout Koulèr Mélanjé</span> a pour objectif de vous faire découvrir ou redécouvrir la richesse de la Guyane Française à travers différentes activités. Avec un carnet à votre disposition, vous pourrez ajouter dans votre liste de favoris les activités souhaitées, prendre contact avec les organisateurs, obtenir les informations nécessaires et échanger vos expériences inoubliables entre abonnés. </p>

    <div class="m-4">
        <p class="text-center fs-5 fw-bold activity-list"><RouterLink to="/login" class="link-title"> "Authentifiez-vous pour voir les activités et les restaurants"</RouterLink>
        </p>
    </div>

        <section class=" row fw-semibold text-center m-4">
            <div class="col-12 col-md-4 p-3 d-flex justify-content-center" v-for="activity in homeActivities" :key="activity.id">
                <!--children of the same common parent must have unique key-->

                <div class="card w-100 shadow">
                    <img v-bind:src= "activity.imageUrl" class="card-img-top" :alt= "activity.alt">
                    <div class="card-body">
                        <h2>{{ activity.title }}</h2>
                        <p class="card-text">{{ activity.prez }}</p>
                    </div>
                </div>
            </div>
        </section>

    <p class="text-center slogan fs-1 fw-medium">Lagwiyann ka antann zot ! </p>
</template>