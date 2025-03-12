// components/CarCard.jsx
import React from 'react';
 
function CarCard({ car }) {
  return (
    <div className="car-card">
      <div className="car-image">
        <img src={car.image} alt={`${car.make} ${car.model}`} />
      </div>
      <div className="car-info">
        <h3>{car.year} {car.make} {car.model}</h3>
        <p className="car-price">${car.price.toLocaleString()}</p>
      </div>
    </div>
  );
}
 
export default CarCard;
 