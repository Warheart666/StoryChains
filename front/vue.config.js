module.exports = {
    devServer:
        {
            port: 3000,
            proxy:
                {
                    '/': {
                        target: 'http://localhost:8081',
                        ws: false,
                        changeOrigin: true,
                        secure: false
                    }
                }
        },
    transpileDependencies: [
        'vuetify'
    ]
}
