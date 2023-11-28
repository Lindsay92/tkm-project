<template>
    <section class="row  m-5">
        <div class="d-flex justify-content-center">
            <form class=" col-md-6">
                <legend>S'enregistrer</legend>
                <div class="mb-3">
                    <label for="firstName" class="form-label">Prénom*</label>
                    <input type="text"  id="firstName"
                        class="form-control">
                            <!-- <span class="invalid-feedback">
                                <p>message d'erreur</p>
                            </span> -->
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
                <div class="d-flex justify-content-end">
                    <button type="submit" class="btn btn btn-outline-dark mt-3 mb-3  text-white">S'enregistrer</button>
                </div>  
            </form>
        </div>
    </section>
</template>