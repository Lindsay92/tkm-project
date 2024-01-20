<script>
import { RouterLink } from 'vue-router';

export default {
    data() {
        return {
            isAuthenticated : localStorage.getItem("isAuthenticated"),
            role : localStorage.getItem("role"),
            userName : localStorage.getItem("userName")   
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
    <div class=" bg-body-secondary p-5 rounded">
        <h1>Tout Koulèr Mélanjé - Dashboard</h1>
        <p class="lead">
            Gestion de l'application <br>
            Gestion des comptes utilisateurs <br>
            Gestion de son profil
        </p>
    </div>
    
    <nav class="navbar navbar-expand-lg navbar-light">
            <div class="container-fluid color">
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-center fs-3 text" id="navbarNav">
                    <ul class="navbar-nav navbar-nav-scroll">
                        <li class="nav-item">
                            <router-link to="/admin/activities" class="lien-menu nav-link active">
                                Dashboard
                                <i class="bi bi-dot"></i>
                            </router-link>
                        </li>
                        <li class="nav-item">
                            <router-link to="" class="lien-menu nav-link active">
                                Profil 
                                <i class="bi bi-dot"></i>
                            </router-link>
                        </li>   
                        <li class="nav-item">
                            <router-link to="" class="lien-menu nav-link active">
                                Utilisateurs 
                            </router-link>
                        </li>                     
                    </ul>
                </div>

                <div v-if="isAuthenticated && role == 'Administrator'">
                    <span class="nav-item"> Bienvenue {{ userName }}</span>
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