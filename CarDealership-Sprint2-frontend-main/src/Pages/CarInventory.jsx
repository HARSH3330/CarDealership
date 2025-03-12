import { useEffect, useState } from "react";

const CarInventory = () => {
  const [cars, setCars] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [filters, setFilters] = useState({
    make: "",
    model: "",
    year: "",
    price: "",
    colour: "",
  });

  useEffect(() => {
    fetch("http://localhost:8080/viewAll") // Fetch all cars initially
      .then((response) => {
        if (!response.ok) {
          throw new Error("Failed to fetch cars");
        }
        return response.json();
      })
      .then((data) => {
        setCars(data);
        setLoading(false);
      })
      .catch((err) => {
        setError(err.message);
        setLoading(false);
      });
  }, []);

  const handleSearch = () => {
    console.log("Search button clicked!"); 

    fetch("http://localhost:8080/searchCar", {
        method: "POST", // Use POST method
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(filters), // Send filters as JSON body
    })
    .then((response) => {
        if (!response.ok) {
            throw new Error("Failed to search cars");
        }
        return response.json();
    })
    .then((data) => {
        console.log("Received data:", data); // Debugging
        setCars(data);

        if (data.length === 0) {
          setCars([]);  // Clear previous results
          setError("Sorry, we don't have that");
      } else {
          setCars(data);
          setError(""); // Clear previous error message
      }
    })
    .catch((err) => {
        console.error("Error:", err.message);
        setError(err.message);
    });
};


  return (
    <div className="container mx-auto px-4 py-8">
      <h1 className="text-4xl font-bold text-center text-gray-800 mb-6">Car Inventory</h1>

      {/* Search & Filter Section */}
      <div className="flex flex-wrap justify-center gap-4 mb-6">
        <input
          type="text"
          placeholder="Make"
          value={filters.make}
          onChange={(e) => setFilters({ ...filters, make: e.target.value })}
          className="border p-2 rounded-md"
        />
        <input
          type="text"
          placeholder="Model"
          value={filters.model}
          onChange={(e) => setFilters({ ...filters, model: e.target.value })}
          className="border p-2 rounded-md"
        />
        {/*<select
          value={filters.year}
          onChange={(e) => setFilters({ ...filters, year: e.target.value })}
          className="border p-2 rounded-md"
        >
          
          <option value="">Year</option>
          <option value="2024">2024</option>
          <option value="2023">2023</option>
          <option value="2022">2022</option>
          {/* Add more years if needed */}
        {/*</select>
        <select
          value={filters.price}
          onChange={(e) => setFilters({ ...filters, price: e.target.value })}
          className="border p-2 rounded-md"
        >
          <option value="">Price</option>
          <option value="5000">Below $5,000</option>
          <option value="10000">Below $10,000</option>
          <option value="20000">Below $20,000</option>
        </select>
        <select
          value={filters.colour}
          onChange={(e) => setFilters({ ...filters, colour: e.target.value })}
          className="border p-2 rounded-md"
        >
          <option value="">Colour</option>
          <option value="Red">Red</option>
          <option value="Black">Black</option>
          <option value="White">White</option>
  </select>*/}
        <button
          onClick={handleSearch}
          className="bg-blue-600 text-white px-4 py-2 rounded-md hover:bg-blue-700"
        >
          Search
  </button>
      </div>

      {/* Display Cars */}
      {loading && <p className="text-center text-lg">Loading cars...</p>}
      {error && <p className="text-center text-red-600">Error: {error}</p>}

      {!loading && !error && cars.length === 0 && (
        <p className="text-center text-gray-600">No cars available.</p>
      )}

      {!loading && !error && (
        <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-6">
          {cars.map((car) => (
            <div key={car.carid} className="bg-white p-4 shadow-md rounded-lg border border-gray-200">
              <h2 className="text-2xl font-semibold text-gray-700">
                {car.make} {car.model}
              </h2>
              <p className="text-gray-500">Year: {car.year}</p>
              <p className="text-gray-500">Color: {car.colour}</p>
              <p className="text-gray-500">Price: ${car.price.toLocaleString()}</p>
              <p className="text-gray-500">KMs Driven: {car.kms_driven.toLocaleString()} km</p>
              <p className="text-gray-500">Previous Owners: {car.no_owners}</p>
              <p className={`font-bold ${car.status === 1 ? "text-green-600" : "text-red-600"}`}>
                Status: {car.status === 1 ? "Available" : "Sold"}
              </p>
            </div>
          ))}
        </div>
      )}
    </div>
  );
};

export default CarInventory;
