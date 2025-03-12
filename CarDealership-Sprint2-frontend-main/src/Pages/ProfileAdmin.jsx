import React, { useState, useEffect } from 'react';
//import { useAuth } from '../context/AuthContext';
//import CarCard from './CarCard';
import { AuthContext } from '../Providers/AuthProvider';
import { useAuth } from "../Providers/AuthProvider";


function ProfileAdmin() {
  const { currentUser } = useAuth();
  const [sales, setSales] = useState([]);
  const [loading, setLoading] = useState(true);
  const [salesStats, setSalesStats] = useState({
    totalSales: 0,
    totalRevenue: 0,
    pendingDeliveries: 0
  });

  useEffect(() => {
    // This would normally fetch from an API
    // For demo purposes, we'll use mock data
    const fetchSales = () => {
      const mockSales = [
        {
          id: 'sale1',
          carId: 'car1',
          make: 'Toyota',
          model: 'Camry',
          year: 2022,
          image: 'https://via.placeholder.com/150',
          price: 25000,
          saleDate: '2025-02-15',
          status: 'Delivered',
          buyerName: 'John Smith',
          buyerEmail: 'john@example.com'
        },
        {
          id: 'sale2',
          carId: 'car2',
          make: 'Honda',
          model: 'Accord',
          year: 2023,
          image: 'https://via.placeholder.com/150',
          price: 28000,
          saleDate: '2025-03-01',
          status: 'Processing',
          buyerName: 'Jane Doe',
          buyerEmail: 'jane@example.com'
        },
        {
          id: 'sale3',
          carId: 'car3',
          make: 'Tesla',
          model: 'Model 3',
          year: 2023,
          image: 'https://via.placeholder.com/150',
          price: 45000,
          saleDate: '2025-02-20',
          status: 'Pending Delivery',
          buyerName: 'Robert Johnson',
          buyerEmail: 'robert@example.com'
        },
        {
          id: 'sale4',
          carId: 'car4',
          make: 'Ford',
          model: 'Mustang',
          year: 2024,
          image: 'https://via.placeholder.com/150',
          price: 52000,
          saleDate: '2025-03-05',
          status: 'Delivered',
          buyerName: 'Sarah Williams',
          buyerEmail: 'sarah@example.com'
        }
      ];
      
      setSales(mockSales);
      
      // Calculate stats
      const totalRevenue = mockSales.reduce((sum, sale) => sum + sale.price, 0);
      const pendingDeliveries = mockSales.filter(sale => sale.status === 'Pending Delivery').length;
      
      setSalesStats({
        totalSales: mockSales.length,
        totalRevenue,
        pendingDeliveries
      });
      
      setLoading(false);
    };

    fetchSales();
  }, [currentUser.id]);

  if (loading) {
    return <div className="loading">Loading your sales data...</div>;
  }

  return (
    <div className="profile-container">
      <div className="profile-header">
        <h1>Dealer Profile</h1>
        <div className="dealer-info">
          <p><strong>Dealership Name:</strong> {currentUser.name}</p>
          <p><strong>Email:</strong> {currentUser.email}</p>
        </div>
      </div>
      
      <div className="stats-dashboard">
        <div className="stat-card">
          <h3>Total Sales</h3>
          <div className="stat-value">{salesStats.totalSales}</div>
        </div>
        <div className="stat-card">
          <h3>Total Revenue</h3>
          <div className="stat-value">${salesStats.totalRevenue.toLocaleString()}</div>
        </div>
        <div className="stat-card">
          <h3>Pending Deliveries</h3>
          <div className="stat-value">{salesStats.pendingDeliveries}</div>
        </div>
      </div>
      
      <div className="sales-section">
        <h2>My Sales</h2>
        {sales.length === 0 ? (
          <p className="no-sales">You haven't made any sales yet.</p>
        ) : (
          <div className="sales-grid">
            {sales.map(sale => (
              <div key={sale.id} className="sale-card">
                <CarCard car={sale} />
                <div className="sale-details">
                  <p><strong>Sale Date:</strong> {sale.saleDate}</p>
                  <p><strong>Status:</strong> <span className={`status-${sale.status.toLowerCase().replace(' ', '-')}`}>{sale.status}</span></p>
                  <p><strong>Buyer:</strong> {sale.buyerName}</p>
                  <p><strong>Buyer Email:</strong> {sale.buyerEmail}</p>
                </div>
              </div>
            ))}
          </div>
        )}
      </div>
    </div>
  );
}

export default ProfileAdmin;
