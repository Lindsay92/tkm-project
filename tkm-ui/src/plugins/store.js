import { defineStore } from 'pinia';

export const useStore = defineStore({
    id: 'main',
    state: () => ({
        favorites: [],
    }),
    actions: {
        addFavorite(activityId) {
            this.favorites.push(activityId);
        },
        removeFavorite(activityId) {
            let index = this.favorites.indexOf(activityId);
            if (index !== -1) {
                this.favorites.splice(index, 1);
            }
        },        
    },
    getters: {
        isFavorite: (state) => (activityId) => {
          return state.favorites.includes(activityId);
        },
    // getters: {
    //     isFavorite: state => activity => {
    //         return state.favorites.some(id => id === activity);
    //     },
    },
});
