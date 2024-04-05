import { defineStore } from 'pinia';

export const useStore = defineStore({
    id: 'main',
    state: () => ({
        favorites: [],
    }),
    actions: {
        addFavorite(activity) {
            this.favorites.push(activity);
        },
        removeFavorite(activityId) {
            const index = this.favorites.indexOf(activityId);
            if (index !== -1) {
                this.favorites.splice(index, 1);
            }
        },        
    },
    getters: {
        isFavorite: state => activityId => {
            return state.favorites.some(id => id === activityId);
        },
    },
});
