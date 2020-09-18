using Carter;
using Carter.Response;
using Garageasy.API.Models;
using Microsoft.AspNetCore.Diagnostics;
using Microsoft.AspNetCore.Http;
using System;
using System.Collections.Generic;
using System.Net;
using System.Runtime.CompilerServices;
using System.Security.Authentication;
using System.Threading.Tasks;

namespace Garageasy.API.Modules
{
    public class ErrorModule : CarterModule
    {
        public ErrorModule()
        {
            this.Get("/errorhandler", (req, res) =>
            {
                return HandleError(req, res);
            });

            this.Post("/errorhandler", (req, res) =>
            {
                return HandleError(req, res);
            });
        }

        private Task HandleError(HttpRequest req, HttpResponse res)
        {
            Exception exception;
            var feature = req.HttpContext.Features.Get<IExceptionHandlerFeature>();

            if (feature != null)
            {
                res.StatusCode = (int)GetErrorCode(feature.Error);
                exception = feature.Error;
            }
            else
            {
                exception = new Exception("An unknown error ocurred");
            }

            //At this point we can do a log into the database.
            Console.Write(exception.ToString());

            var errorMsg = feature?.Error?.Message;
            return res.Negotiate(new ApiResponse<string>
            {
                Error = new Error(errorMsg)
            });
        }

        private static HttpStatusCode GetErrorCode(Exception e)
        {
            switch (e)
            {
                case ArgumentException _:
                    return HttpStatusCode.BadRequest;
                case FormatException _:
                    return HttpStatusCode.BadRequest;
                case AuthenticationException _:
                    return HttpStatusCode.Forbidden;
                case KeyNotFoundException _:
                    return HttpStatusCode.NotFound;
                case NotImplementedException _:
                    return HttpStatusCode.NotImplemented;
                default:
                    return HttpStatusCode.InternalServerError;
            }
        }
    }
}
