<script>
import { RouterLink, useRoute } from 'vue-router';

export default {
    setup() {
        return {
            route: useRoute()
        }
    },

    data() {
        return {
            isAuthenticated : localStorage.getItem("isAuthenticated"),
            role : localStorage.getItem("role"),
            userName : localStorage.getItem("userName"),
            id:1
        }
    },
    methods: {
        async initAccount() {
            this.userName = localStorage.getItem("userName")
            this.isAuthenticated = localStorage.getItem("isAuthenticated");
            this.role = localStorage.getItem("role");
    },
        signOut(){
            localStorage.clear();
            this.isAuthenticated = null;
            this.userName = null;
            this.role = null;
        }
    },
    beforeMount(){
        this.initAccount();   
    }
}
</script>

<template>
    <div class="z-0">
        <img src="/images/banner.png" alt="" class="image">
    </div>
    <div class="row">
        <div class="d-flex justify-content-end z-1 position-absolute bottom-0 start-50 translate-middle-x  ">
            <span class="btnColor" id="scrollUp">
                <h1><a href="#bottom"><i class="bi bi-arrow-down-circle"></i></a></h1>
            </span>
        </div>
    </div>

    <nav id="bottom" class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid color">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse justify-content-center fs-3 text" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <router-link to="/user/home" class="lien-menu nav-link active">
                            Accueil
                            <i class="bi bi-dot"></i>
                        </router-link>
                    </li>
                    <li class="nav-item">
                        <router-link to="/user/activities" class="lien-menu nav-link active">
                            Liste des activités 
                            <i class="bi bi-dot"></i>
                        </router-link>
                    </li>   
                    <li class="nav-item">
                        <router-link to="/user/map" class="lien-menu nav-link active">
                            Carte 
                            <i class="bi bi-dot"></i>
                        </router-link>
                    </li>                     
                    <li class="nav-item">
                        <router-link to="/user/about" class="lien-menu nav-link active">
                            Formalités
                        </router-link>
                    </li>
                </ul>
            </div>

            <div v-if="isAuthenticated && role == 'User'">
                <span class="nav-item"> Bienvenue {{ userName }}</span>
                <!-- <router-link   
                    :to="`/user/activities/${this.id}/favorite`"
                    class="lien-menu nav-link active"><i class="bi bi-airplane"></i> 
                        Mon carnet de favoris                       
                </router-link> -->
            <!-- <div v-for="activity in activities">
                <div v-if="activity">
                    test {{ activity.id }}
                </div>
            </div> -->
                <router-link   
                    :to="{ name: 'profile-user', params: {id}}"
                    class="lien-menu nav-link active"><i class="bi bi-airplane"></i> 
                        Mon carnet de favoris                       
                </router-link>


                <router-link   
                    :to="{ name: 'login'}"
                    class="lien-menu nav-link active"
                    @click="signOut"><i class="bi bi-box-arrow-right"></i>
                        Se déconnecter
                </router-link>
            </div>

            <div v-if="!isAuthenticated">
                <router-link  to="/login" class="lien-menu nav-link active">
                    <h1><i class="bi bi-person-fill w-25"></i></h1>
                </router-link>
            </div>           
        </div>
    </nav> 
</template>