<template>
    <h1 class="text-center m-5">S'enregistrer</h1>

        <form class="container col-12 col-md-6 p-3">
            <div class="mb-3">
                <label for="firstName" class="form-label">Prénom*</label>
                <input type="text"  id="firstName"
                    class="form-control">
                    <span class="invalid-feedback">
                        <p>message d'erreur</p>
                    </span>
            </div>
            <div class="mb-3">
                <label for="lastName" class="form-label">Nom*</label>
                <input type="text"
                    id="lastName" class="form-control" >
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email*</label>
                <input type="email" id="email" class="form-control">
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Mot de passe*</label>
                <input type="text" id="password" class="form-control">
            </div>
        
            <button type="submit" class="btn btn btn-outline-dark mt-3 mb-3">S'enregistrer</button>

        </form>
</template>