<script>
    export default {
    setup() {
        const key = import.meta.env.VITE_MAPS_EMBED_API_KEY;
        return {
            mapsUrl: `https://www.google.com/maps/embed/v1/view?key=${key}&center= 4.9370748,-52.3346534&zoom=15&language=fr`
        }
    }
}
</script>

<template>
    <h1 class="text-center m-5">{{ $t('mapPage.title') }}</h1>
        <div class="text-center mb-3 d-flex justify-content-end">
            <button class="btn btn-dark">
                <router-link :to="{name: 'activities'}" class="text-decoration-none link text-light">
                    {{ $t('mapPage.back') }}
                </router-link>
            </button>
        </div>

        <div class="col-12 shadow m-1">
            <div class="ratio ratio-16x9 border rounded-2 shadow-sm">
                <iframe loading="lazy" 
                        frameborder="0" 
                        style="border:0"
                        referrerpolicy="no-referrer-when-downgrade"
                        allowfullscreen  
                        :src="mapsUrl" 
                        title="Carte de géolocalisation">
                </iframe>
            </div>
        </div>
</template>