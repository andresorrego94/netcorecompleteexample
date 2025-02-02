﻿using Carter;
using Carter.ModelBinding;
using Carter.Response;
using Garageasy.API.Models;
using Microsoft.AspNetCore.Http;

namespace Garageasy.API.Modules
{
    public class HealthModule: CarterModule
    {
        public HealthModule()
        {
            Get("/health", async (req, res) =>
            {
                //var request = req.Bind<WeatherForecast>();

                await res.Negotiate(new ApiResponse<string>
                {
                    Data = "Alive !"
                });
            });

            Get("/test", async (req, res) => await res.WriteAsync("Alive 1!"));
        }
    }
}
