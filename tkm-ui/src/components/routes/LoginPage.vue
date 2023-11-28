<script>
import { RouterLink } from 'vue-router';
</script>

<template>
    <div class="row m-5">
        <div class="d-flex justify-content-center d-flex align-items-center">
            <section class="row flex-fill m-5">
                <form class=" border border-dark rounded">
                    <legend>Se connecter</legend>
                    <div class="mb-3">
                        <label for="email" class="form-label">Email*</label>
                        <input type="email" class="form-control" id="email">
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Mot de passe*</label>
                        <input type="password" class="form-control" id="password">
                    </div>
                    <div class="d-flex justify-content-end">
                        <button type="submit" class="btn btn-outline-dark mb-3 mt-3 text-white">Se connecter</button>
                    </div>

                    <p class="text-center m-3">
                    <RouterLink to= "/auth" class="link">Si vous n’avez pas de compte, cliquez sur le lien</RouterLink>
                    </p>   
                </form>
            </section>
            <section>
                <img src="/images/jaguar.jpg" class="rounded-4" alt="">
            </section>
        </div>
    </div>
</template>