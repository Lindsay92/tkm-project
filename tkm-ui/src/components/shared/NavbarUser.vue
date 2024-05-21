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
                            {{ $t("shared.navbar.homePage") }}
                            <i class="bi bi-dot"></i>
                        </router-link>
                    </li>
                    <li class="nav-item">
                        <router-link to="/user/activities" class="lien-menu nav-link active">
                            {{ $t("shared.navbar.activities") }} 
                            <i class="bi bi-dot"></i>
                        </router-link>
                    </li>   
                    <li class="nav-item">
                        <router-link to="/user/map" class="lien-menu nav-link active">
                            {{ $t("shared.navbar.map") }} 
                            <i class="bi bi-dot"></i>
                        </router-link>
                    </li>                     
                    <li class="nav-item">
                        <router-link to="/user/about" class="lien-menu nav-link active">
                            {{ $t("shared.navbar.formality") }}
                        </router-link>
                    </li>
                </ul>
            </div>

            <div v-if="isAuthenticated && role == 'User'">
                <span class="nav-item"> {{ $t("shared.navbarAdmin.welcome") }} {{ userName }}</span>
                <router-link   
                    :to="{name: 'profile-user'}"
                    class="lien-menu nav-link active"><i class="bi bi-airplane"></i> 
                    {{ $t("shared.navbar.favory") }}                      
                </router-link>
                <router-link   
                    :to="{ name: 'login'}"
                    class="lien-menu nav-link active"
                    @click="signOut"><i class="bi bi-box-arrow-right"></i>
                    {{ $t("shared.navbarAdmin.disconnect") }}
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