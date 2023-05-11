<script>
import { RouterLink } from 'vue-router';

export default {
    data() {
        return {
            baseUrl: import.meta.env.VITE_IMG_BASE_URL,
            activities: []
        }
    },
    methods: {
        async initActivities() {
            const response = await this.$axios.get('/activities/for-edit');
            this.activities = response.body;
        },
        // async remove(id) {
        //     const resp = await this.$http.delete(`/stickers/${id}`);
        //     if (resp.status === 204) {
        //         this.$toast.success('toast-global', 'Sticker deleted with success.');
        //         await this.initStickers();
        //     } else {
        //         console.error(resp);
        //         this.$toast.error('toast-global', 'Server error.');
        //     }
        // }
    },
    beforeMount() {
        this.initActivities();
    }
}
</script>
<template>
    <h1>Edit activities</h1>
    <div class="table-responsive">
        <table class="table table-hover">
            <thead>
                <tr class="text-center align-middle">
                    <th scope="col">Image</th>
                    <th class="col" scope="col">Name</th>
                    <th class="col" scope="col">Description</th>
                    <th scope="col">ImageUrl</th>
                    <th class=""  scope="col">LinkUrl</th>
                    <!-- <th scope="col">Date added</th> -->
                    <th scope="col">Update</th>
                    <th scope="col">Delete</th>
                </tr>
            </thead>
            <tbody class="text-nowrap  align-middle">
                <tr v-for="activity in activities">
                    <td class="text-center"><img :src="baseUrl + activity.imageUrl" class="img-fluid"
                            :alt="activity.name">
                    </td>
                    <td>{{ activity.name }}</td>
                    <td>{{ activity.description }}</td>
                    <td>{{ activity.imageUrl }}</td>
                    <td>{{ activity.linkUrl }}</td>
                    <!-- <td>date</td> -->
                    <!-- <td>{{ this.$fmt.date(activity.createdAt) }}</td> -->
                    <td class="text-center">
                        <RouterLink :to="{ name: 'activity-update', params: { id: activity.id } }" title="Update activity">
                            <i class="bi bi-pencil-square text-primary"></i>
                        </RouterLink>
                    </td>
                    <td class="text-center"><a href="#" @click="remove(activity.id)"><i
                                class="bi bi-trash3 text-danger"></i></a></td>
                </tr>
            </tbody>
        </table>
    </div>
</template>