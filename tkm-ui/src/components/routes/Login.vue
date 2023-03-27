<template>
    <h1 class="text-center m-3">Se connecter</h1>
        <section class="row justify-content-center">
        <form class="col-md-6 ">
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email">
            </div>

            <div class="mb-3">
                <label for="password" class="form-label">Mot de passe</label>
                <input type="password" class="form-control" id="password">
            </div>
    

            <button type="submit" disabled class="btn btn-secondary">Envoyer</button>
        </form>

            <p class="text-center m-3">
                <RouterLink to= "/auth" class="link">Si vous n’avez pas de compte, cliquez sur le lien</RouterLink>
            </p>    
    </section>

</template>