using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Garageasy.API.Models
{
    public class Error
    {
        public string Message { get; set; }
        public Error() { }

        public Error(string message)
        {
            Message = message;
        }

        protected bool Equals(Error other)
        {
            return Message == other.Message;
        }

        public override bool Equals(object obj)
        {
            var error = obj as Error;
            return error != null &
                Message == error.Message;
        }

        public override int GetHashCode()
        {
            unchecked
            {
                var hashCode = (Message != null ? Message.GetHashCode() : 0);
                return hashCode;
            }
        }
    }
}
