const storage = {

    set(key, value) {

        window.localStorage.setItem(key, value)

    },

    get(key) {

        return window.localStorage.getItem(key)

    },

    remove(key) {

        window.localStorage.removeItem(key)

    }

}

export default storage