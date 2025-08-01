namespace dotnet_api_weatherapp.Models
{
    public class WeatherReport
    {
        public int Id { get; set; }
        public string City { get; set; }
        public string Description { get; set; }
        public double Temperature { get; set; }
        public DateTime Date { get; set; }
        public int UserId { get; set; }

        public User User { get; set; }
    }

}
