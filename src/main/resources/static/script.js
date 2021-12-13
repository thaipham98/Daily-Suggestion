$(document).ready(
    /**
     * Display data when user clicks on the button to get the weather
     */
    function () {
        $("#get_weather_forecast").click(function () {
            var zip = $("#zip").val();
            var key = "207e19459d3c8a3b9350554022c23635";

            if (zip == '') {
                $("#show_weather").html('Please provide a zip code')
            } else {
                $.ajax({
                    url: 'http://api.openweathermap.org/data/2.5/weather',
                    dataType: 'json',
                    type: 'GET',
                    data: {zip: zip, appid: key, units: 'metrics'},

                    success: function (data) {
                        var city_icon = '';
                        var weather = '';

                        $.each(data.weather, function (index, val) {

                            var iconSrc = "http://openweathermap.org/img/w/" + val.icon + '.png';
                            data.main.temp = parseInt(data.main.temp);
                            data.main.temp = (data.main.temp - 273.15) * 9 / 5 + 32;
                            data.main.temp = data.main.temp.toFixed(1);
                            city_icon = '<p><b>' + data.name + '</b><img src=' + iconSrc + '>' + '</p>';
                            weather = data.main.temp + '&deg;F ' + ' | ' + val.main + ", " + val.description
                        });
                        $("#show_city_icon").html(city_icon);
                        $("#show_weather").html(weather);
                        console.log(weather);
                    },

                    error: function () {
                        $("#show_weather").html("This city does not exist")
                    }

                }); //end ajax
            }
        }); // end weather click

        /**
         * Display data when user clicks on the button to get suggestion
         */
        $("#suggest_thing_to_do").click(function () {
            var occupation = '';
            if(document.getElementById('student').checked) {
                occupation += 'student';
            }else if(document.getElementById('worker').checked) {
                occupation += 'worker';
            }

            var character = '';
            if(document.getElementById('introvert').checked) {
                character += 'introvert';
            }else if(document.getElementById('extrovert').checked) {
                character += 'extrovert';
            }



            console.log(occupation);
            console.log(character);

            var city = $('#show_city_icon').text();
            console.log(city);


            if ((occupation == '' || character == '') && city == '') {
                $("#show_thing_to_do").html("Please complete Profile and Weather sections");
            } else {
                if (occupation == '' || character == '') {
                    $("#show_thing_to_do").html("Please complete Profile section");
                }
                else if (city == '') {
                    $("#show_thing_to_do").html("Please complete Weather section");
                }
                else {
                    var weather = $('#show_weather').text();
                    //console.log("here");
                    console.log(weather);
                    $.ajax({
                        url: 'http://localhost:8080/suggest',
                        dataType: 'json',
                        type: 'GET',
                        data: {occupation: occupation, character: character, weather: weather},

                        success: function (data) {
                            console.log(data);
                            $("#show_thing_to_do").html(data.response);
                        },

                        error: function () {
                            $("#show_thing_to_do").html("No suggestion is found");
                        }

                    }); //end ajax

                }
            }

        }); // end suggestion click
    }


); // end ready