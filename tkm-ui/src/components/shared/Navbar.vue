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
        signOut(){
            localStorage.clear();
            this.isAuthenticated = null;
            this.userName = null;
            this.role = null;
        }
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
            <div>    
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
                            <router-link to="/" class="lien-menu nav-link active">
                                Accueil
                                <i class="bi bi-dot"></i>
                            </router-link>
                        </li>
                        <li class="nav-item">
                            <router-link to="/activities" class="lien-menu nav-link active">
                                Liste des activités 
                                <i class="bi bi-dot"></i>
                            </router-link>
                        </li>   
                        <li class="nav-item">
                            <RouterLink to="/map" class="lien-menu nav-link active">
                                Carte 
                                <i class="bi bi-dot"></i>
                            </RouterLink>
                        </li>                     
                        <li class="nav-item">
                            <RouterLink to="/about" class="lien-menu nav-link active">
                                Formalités
                            </RouterLink>
                        </li>
                    </ul>
                </div>

                <div v-if="isAuthenticated && role == 'User'">
                    <span class="nav-item"> Bienvenue {{ userName }}</span>
                    <RouterLink   
                        :to="{ name: 'profile-user'}"
                        class="lien-menu nav-link active"><i class="bi bi-airplane"></i> 
                        Mon carnet de favoris                       
                    </RouterLink>
                    <RouterLink   
                        :to="{ name: 'login'}"
                        class="lien-menu nav-link active"
                        @click="signOut"><i class="bi bi-box-arrow-right"></i>
                        Se déconnecter
                    </RouterLink>
                </div>

                <div v-if="isAuthenticated && role == 'Administrator'">
                    <span class="nav-item"> Bienvenue {{ userName }}</span>
                    <RouterLink   
                        :to="{ name: 'login'}"
                        class="lien-menu nav-link active"
                        @click="signOut"><i class="bi bi-box-arrow-right"></i>
                        Se déconnecter
                    </RouterLink>
                </div>
                
                <div v-if="!isAuthenticated">
                    <RouterLink  to="/login" class="lien-menu nav-link active">
                        <h1><i class="bi bi-person-fill w-25"></i></h1>
                    </RouterLink>
                </div>
                
            </div>
        </nav>
    <p> Current value: {{ isAuthenticated }}</p>
    <p> Current value: {{ role }}</p>
    <p> Current value: {{ userName }}</p>
</template>