<template>
    <header>
        <h1 class="title text-center m-5">
            Tout Koulèr Mélanjé
        </h1>

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
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
                            </router-link>
                        </li>
                        <li class="nav-item">
                            <router-link to="/activities" class="lien-menu nav-link active">
                                Liste des activités
                            </router-link>
                        </li>   
                        <li class="nav-item">
                            <RouterLink to="/map" class="lien-menu nav-link active">
                                Carte
                            </RouterLink>
                        </li>                     
                        <li class="nav-item">
                            <RouterLink to="/about" class="lien-menu nav-link active">
                                A propos
                            </RouterLink>
                        </li>
                    </ul>
                </div>

                <div>
                    <RouterLink to="/login" class="lien-menu nav-link active">
                        <!-- <img src="src/assets/user.svg"> -->
                        <h1><i class="bi bi-person-fill w-25"></i></h1>
                    </RouterLink>
                </div>
            </div>
        </nav>
    </header>
</template>