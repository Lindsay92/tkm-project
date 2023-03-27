<template>
    <h1 class="text-center m-5">La Guyane Française, un pays au mille visages !</h1>

    <p class="text-center slogan m-3 "> Tout Koulèr Mélanjé est une application qui fait référence à la diversité du territoire guyanais. C'est un pays pluriculturel où se mélange différentes communautés (des Amérindiens, des Hmongs, des Brésiliens, des Chinois, des Guyanais, des Businengés…). <br>
    Ce pays méconnu et ayant parfois une mauvaise réputation se révèle comme une terre accueillante offrant une expérience exceptionnelle et inoubliable. <br>
    Tout Koulèr Mélanjé aura pour objectif de vous faire découvrir ou redécouvrir la richesse guyanaise à travers différentes activités.</p>

    <div class="m-5">
        <p class="text-center fs-5 fw-bold activity-list"><RouterLink to="/login" class="link-title"> "Authentifiez-vous pour voir les activités et les restaurants"</RouterLink>
        </p>
    </div>

    <div class="container">

        <div class="row fw-semibold text-center mb-5 justify-content-center">

            <div class="card col-12 col-md-4 p-3">
                <img src="src/assets/images/accueilImage/forest.jpg" class="card-img-top" alt="Forêt Amazonienne">
                <div class="card-body">
                    <h2>Activités Naturelles</h2>
                    <p class="card-text">Envie de découvrir une faune exceptionnelle, une biodiversité incroyable, des plages à perte de vue, des criques secrètes, des couchés de soleil flamboyants...</p>
                </div>
            </div>
            <div class="card col-12 col-md-4 p-3 ">
                <img src="src/assets/images/accueilImage/house.jpg" class="card-img-top" alt="Une maison créole">
                <div class="card-body">
                    <h2>Activités Culturelles</h2>
                    <p class="card-text">Envie d'apprendre et de découvrir les différentes communautés guyanaises, l'artisanat local, les coutumes du pays, d'échanger avec les habitants... </p>
                </div>
            </div>
            <div class="card col-12 col-md-4 p-3 ">
                <img src="src/assets/images/accueilImage/spices.jpg" class="card-img-top" alt="Du piment">
                <div class="card-body">
                    <h2>Restaurants et marchés</h2>
                <p class="card-text">Envie de sentir les épices au marché de Cayenne, de goûter les différents plats familiaux tout en s'abandonnant à un petit verre de rhum "La Belle Cabresse"...</p>
            </div>
        </div>
    </div>
</div>
</template>