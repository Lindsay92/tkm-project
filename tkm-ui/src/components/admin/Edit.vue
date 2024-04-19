<script>
import { RouterLink } from 'vue-router';

export default {
    data() {
        return {
            baseUrl: import.meta.env.VITE_IMG_BASE_URL,
            activities: []
        };
    },
    methods: {
        async initActivities() {
            const response = await this.$axios.get('/activities/for-edit');
            this.activities = response.body;
            this.initActivities();
        },
        async remove(id) {
            const response = await this.$axios.delete(`/activities/${id}/delete`);
            if (response.status === 204) {
                this.$toast.success('toast-global', 'L\'activité a bien été supprimée');
                window.scrollTo(0, 0);
                await this.initActivities();
            }
            else {
                console.error(response);
                window.scrollTo(0, 0);
                this.$toast.error('toast-global', 'Une erreur s\'est produite.');
            }
        }
    },
    beforeMount() {
        this.initActivities();
    },
}
</script>

<template>
    <h1 class="text-center m-5">Les activities</h1>
    <div class="d-md-flex justify-content-start m-3">
        <button class="btn btn-dark"><RouterLink :to="{name: 'activities-create'}" class="text-decoration-none link text-light">Créer une nouvelle activité</RouterLink></button>
    </div>
    <div class="table-responsive">
        <table class="table table-hover table-sm">
            <thead>
                <tr class="text-center align-middle">
                    <th scope="col">Image</th>
                    <th scope="col">Nom</th>
                    <th scope="col">Date</th>
                    <th scope="col">Maj</th>
                    <th scope="col">Supprimer</th>
                </tr>
            </thead>
            <tbody class="text-wrap align-middle text-center table-group-divider">
                <tr v-for="activity in activities" :key="activity.id">
                    <td width="200">
                        <img :src="baseUrl + activity.imageUrl" class="img-fluid w-25"
                                :alt="activity.name">
                    </td>
                    <td>{{ activity.name }}</td>
                    <td>{{ this.$fmt.date(activity.createdAt) }}</td>
                    <td class="text-center">
                        <router-link :to="{ name: 'activity-update', params: { id: activity.id } }" title="Update activity">
                            <i class="bi bi-pencil-square text-primary"></i>
                        </router-link>
                    </td>
                    <td class="text-center">
                        <a href="#" @click="remove(activity.id)" title="Delete activity">
                            <i class="bi bi-trash3 text-danger"></i>
                        </a>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</template>