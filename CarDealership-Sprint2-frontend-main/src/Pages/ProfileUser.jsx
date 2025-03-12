import React, { useState, useEffect } from 'react';
import { useAuth } from '../Providers/AuthProvider';
import CarCard from './CarCard';

function ProfileUser() {
  const { user } = useAuth();
  const [bookings, setBookings] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchBookings = () => {
      const mockBookings = [
        {
          id: 'booking1',
          carId: 'car1',
          make: 'Toyota',
          model: 'Camry',
          year: 2022,
          image: 'https://via.placeholder.com/150',
          price: 25000,
          bookingDate: '2025-02-15',
          status: 'Confirmed',
          dealerName: 'ABC Motors'
        },
        {
          id: 'booking2',
          carId: 'car2',
          make: 'Honda',
          model: 'Civic',
          year: 2021,
          image: 'https://via.placeholder.com/150',
          price: 22000,
          bookingDate: '2025-03-10',
          status: 'Pending',
          dealerName: 'XYZ Autos'
        }
      ];
      
      setBookings(mockBookings);
      setLoading(false);
    };

    if (user) {
      fetchBookings();
    }
  }, [user]);

  if (loading) {
    return <div className="loading">Loading your bookings...</div>;
  }

  return (
    <div className="profile-container">
      <div className="profile-card">
        <h2>User Profile</h2>
        <div className="user-details">
          <p><strong>Name:</strong> {user?.name || "N/A"}</p>
          <p><strong>Email:</strong> {user?.email || "N/A"}</p>
        </div>
      </div>
      
      <div className="bookings-section">
        <h2>My Bookings</h2>
        {bookings.length === 0 ? (
          <p className="no-bookings">You haven't made any bookings yet.</p>
        ) : (
          <div className="bookings-grid">
            {bookings.map((booking) => (
              <div key={booking.id} className="booking-card">
                <CarCard car={booking} />
                <div className="booking-details">
                  <p><strong>Booking Date:</strong> {booking.bookingDate}</p>
                  <p><strong>Status:</strong> <span className={`status-${booking.status.toLowerCase()}`}>{booking.status}</span></p>
                  <p><strong>Dealer:</strong> {booking.dealerName}</p>
                </div>
              </div>
            ))}
          </div>
        )}
      </div>
    </div>
  );
}

export default ProfileUser;
