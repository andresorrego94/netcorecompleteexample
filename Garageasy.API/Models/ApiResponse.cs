using Microsoft.AspNetCore.Diagnostics;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Garageasy.API.Models
{
    public class ApiResponse<T>
    {
        public T Data { get; set; }
        public Error Error { get; set; }
    }
}
