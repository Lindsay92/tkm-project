<script>
import axios from 'axios';
import { RouterLink } from 'vue-router';

export default {
    data() {
        return {
            isAuthenticated: localStorage.getItem("isAuthenticated"),
            role: localStorage.getItem("role"),
            userName: localStorage.getItem("userName"),
            homeActivities: []
        };
    },
    async beforeMount() {
        try {
            const response = await axios.get('/data/homeActivities.json');
            this.homeActivities = response.data;
        } catch (error) {
            this.$toast.error('toast-global', this.$t("common.status.failure"));
        }
    }
}
</script>

<template>
    <h1 class="text-center m-5">{{ $t('homePage.title') }}</h1>

    <p class="text-center slogan m-3 "> 
        <span class="medium">
            {{ $t('homePage.intro')}}
        </span> 
            {{ $t('homePage.description1') }}
        <br>
            {{ $t('homePage.description2') }} 
        <br>
        <br>
            {{ $t('homePage.description3') }} 
        <span class="medium">
            {{ $t('homePage.intro')}}
        </span> 
            {{ $t('homePage.description4') }} 
        <br>
        <br>
            {{ $t('homePage.description5') }} 
    </p>

    <div v-if="isAuthenticated && role == 'User'" class="m-4">
        <p class="text-center fs-5 fw-bold activity-list">
            <RouterLink to="/user/activities" class="link-title"> 
                "{{ $t('homePage.link') }}" 
            </RouterLink>
        </p>
    </div>
    <div v-else class="m-4">
        <p class="text-center fs-5 fw-bold activity-list">
            <RouterLink to="/activities" class="link-title"> 
                "{{ $t('homePage.link') }}" 
            </RouterLink>
        </p>
    </div>

        <section class=" row fw-semibold text-center m-4">
            <div class="col-12 col-md-4 p-3 d-flex justify-content-center" v-for="activity in homeActivities" :key="activity.id">
                <div class="card w-100 shadow">
                    <router-link to="/activities" class="link-title">
                        <img v-bind:src= "activity.imageUrl" class="card-img-top" :alt= "activity.alt">
                    </router-link>
                    <div class="card-body">
                        <h2 class="activityName">{{ activity.title }}</h2>
                        <p class="card-text">{{ activity.prez }}</p>
                    </div>
                </div>
            </div>
        </section>
</template>