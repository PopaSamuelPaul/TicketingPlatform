import React, { useState, useEffect } from 'react';
import api from '../services/api';

interface Event {
    id: number;
    Name: string; // Corectat: 'name' cu literă mică
    totalTickets: number;
    availableTickets: number;
    date: string;
    price: number;
}

const Events = () => {
    const [events, setEvents] = useState<Event[]>([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState('');

    useEffect(() => {
        const fetchEvents = async () => {
            try {
                const response = await api.get('/events');
                setEvents(response.data);
                setLoading(false);
            } catch (err) {
                setError('Couldnt load the events');
                setLoading(false);
            }
        };
        fetchEvents();
    }, []);

    return (
        <div className="min-h-screen bg-gray-100 py-10 px-4 sm:px-6 lg:px-8">
            <div className="max-w-7xl mx-auto">
                <h2 className="text-3xl font-extrabold text-gray-900 text-center mb-8">
                    Concerts and events
                </h2>

                {loading && <p className="text-center text-blue-600 font-semibold text-xl">Loading...</p>}
                {error && <p className="text-center text-red-600 font-bold">{error}</p>}

                <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8">
                    {events.map((event) => (
                        <div key={event.id} className="bg-white rounded-xl shadow-md overflow-hidden hover:shadow-xl transition-shadow duration-300">
                            <div className="p-6">
                                <h3 className="text-xl font-bold text-gray-800 mb-2">
                                    {event.Name}
                                </h3>

                                {/* Corectat: Am mutat {event.date} ÎNĂUNTRUL paragrafului */}
                                <p className="text-gray-600 mb-1">
                                    <span className="font-semibold text-indigo-600 mr-2">
                                        Date:
                                    </span>
                                    {event.date}
                                </p>

                                {/* Corectat: Am mutat simbolul $ lângă preț, nu în textul etichetei */}
                                <p className="text-gray-600 mb-4">
                                    <span className="font-semibold text-indigo-600 mr-2">
                                        Price:
                                    </span>
                                    ${event.price}
                                </p>

                                <button className="w-full bg-indigo-600 hover:bg-indigo-700 text-white font-bold py-2 px-4 rounded-lg transition-colors duration-200">
                                    Buy ticket
                                </button>
                            </div>
                        </div>
                    ))}
                </div>

                {events.length === 0 && !loading && (
                    <p className="text-center text-gray-500 text-lg mt-10">No events at the moment</p>
                )}
            </div>
        </div>
    );
};

export default Events;