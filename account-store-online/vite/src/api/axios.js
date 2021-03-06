import axios from 'axios'


const api = function (url, method ='get', data, header = {'Content-type':'application/x-www-form-urlencoded;charset=utf-8'} ) {
    return new Promise((resolve,reject)=> {
        axios({
            method:method,
            url: url,
            data:data,
            header:header
        }).then(res=> {
            resolve(res)
        }).catch(err=> {
            // 统一做一些处理
            reject(err)
        })
    })
}

export default api


