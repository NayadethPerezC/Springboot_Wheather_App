
function get_coordenadas(){
    //Solicitar la locacion es una operacion larga y costoso, si lo ejecutamos va a finalizar una vez encontrado, por lo que una vez
    //se encuentra la posicion, le pasamos la variable"pos" a otra funcion anonima, la cual va a guardar las variables
    //"lat" y "lon"
    const pos = navigator.geolocation.getCurrentPosition(function (pos) {
        const lat = pos.coords.latitude;
        const lon = pos.coords.longitude;

        get_pronostico(lat, lon)
      });
      console.log("LISTO");
}

async function get_pronostico(lat, lon) {
    const api_key = '2d9878f515a7c5e2c4f9096c986583a8'
    // 1. Creamos la URL con nuestra ubicación actual, y el API_KEY
    const url = `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${api_key}`
    // 2. Realizamos la consulta a la API de OpenWeather
    const resp = await fetch(url)
    // 3. Desempaquetamos la respuesta obtenida
    const data = await resp.json()
    // 4. Obtenemos la temperatura
    const temperature = data.main.temp - 273;
    // 5. Dibujamos la temperatura en la interfaz
    $('#pronostico').html("En este momento hay una temperatura de " + temperature + "°C")
    console.log(data);
  }

get_coordenadas();
