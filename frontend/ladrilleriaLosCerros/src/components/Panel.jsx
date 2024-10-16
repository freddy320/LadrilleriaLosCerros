import { CiBadgeDollar, CiShoppingCart, CiCalculator1, CiUser } from "react-icons/ci";
import { PiBuildingApartmentThin } from "react-icons/pi";
import { Line } from "react-chartjs-2";
import { Chart as ChartJs, CategoryScale, LinearScale, PointElement, LineElement, Tooltip, Legend, Title } from "chart.js";
import Filtros from "./panel/Filtros";
import { useEffect, useState } from "react";
ChartJs.register(CategoryScale, LinearScale, PointElement, LineElement, Tooltip, Legend, Title);




const LineChart = () => {
    const [result, setResult] = useState(null);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const res = await fetch("http://localhost:8080/api/ventas/contar/sucursal/anio?sucursal=Sede%20Norte&anio=2024");
                const data = await res.json();
                console.log(typeof data);
                setResult(data);
            } catch (error) {
                console.error('Fetch error:', error);
            }
        };
        fetchData();
    }, []);

    if (!result) {
        return <p>Cargando datos...</p>;
    }

    const labels = Object.keys(result);
    const data = Object.values(result);

    return (
        <div className="bg-contrast p-4 rounded-xl shadow-lg h-96 w-full">
            <Line
                data={{
                    labels: labels,
                    datasets: [
                        {
                            label: 'Ventas',
                            data: data,
                            backgroundColor: 'rgba(255, 99, 132, 0.2)',
                            borderColor: 'rgba(255, 99, 132, 1)',
                            borderWidth: 1,
                        }
                    ]
                }}
                options={{ responsive: true, maintainAspectRatio: false }}
                className="w-full"
            />
        </div>
    );
};


const ItemPanel = ({ title, resultText, result, icon }) => {
    return (
        <div className='flex gap-2 items-center justify-center'>
            <div className={`w-24 h-24 p-1 rounded-full flex items-center justify-center bg-themePage text-contrast`}>
                {icon}
            </div>
            <div className="basis-36 text-center">
                <h5 className="text-lg opacity-65">{title}</h5>
                <h2 className="text-3xl font-extrabold font-Montserrat px-1">{result}</h2>
                <h6 className="text-sm opacity-65 font-bold text-center">{resultText}</h6>
            </div>
        </div>
    )
}

const CardContainer = ({ title, children }) => {
    return (
        <div className="flex flex-col gap-2">
            <header className="text-center">
                <h2 className="text-xl font-medium">{title}</h2>
            </header>
            <div className="flex gap-4 justify-center">
                {children}
            </div>
        </div>
    )
}

const Card = ({ icon, name }) => {
    return (
        <div className="flex flex-col gap-1 justify-center items-center">
            <div className="w-24 h-24 p-2 rounded-full flex items-center justify-center bg-themePage text-contrast">
                {icon}
            </div>
            <h6 className="flex flex-col justify-center opacity-70">{name}</h6>
        </div>
    )
}

export default function Panel() {
    return (
        <main className=" grid p-2 gap-3 ">

            <section className="bg-contrast p-3 rounded-xl shadow-lg">
                <Filtros title={"Filtros Generales"}/>
            </section>

            <section className='flex gap-8 flex-wrap justify-center bg-contrast p-4 rounded-xl shadow-lg'>
                <ItemPanel title="Ganancias" resultText="$ 50 en el último mes" result="$ 1000" icon={<CiBadgeDollar className="w-12 h-12" />} />
                <ItemPanel title="Promedio" resultText="+ 1.5 de ventas en el último mes" result="50.5" icon={<CiCalculator1 className="w-12 h-12" />} />
                <ItemPanel title="Ventas" resultText="+ 50 ventas en el último mes" result="1000" icon={<CiShoppingCart className="w-12 h-12" />} />
            </section>

            <section className='grid grid-cols-1   2xl:grid-cols-gridMenuGraficts gap-2'>
                <div className='bg-contrast px-5 py-2 rounded-xl shadow-lg grid'>
                    <div>
                        <header className="flex justify-between items-baseline">
                            <h2 className=" text-xl font-semibold">Informe general de ventas</h2>
                        </header>
                        <LineChart/>
                    </div>

                </div>

                <div className='bg-contrast px-5 py-2 rounded-xl shadow-lg grid grid-rows-2 items-center gap-1'>
                    <CardContainer title="Clientes Principales">
                        <Card icon={<CiUser className="text-5xl" />} name="Cliente1" />
                        <Card icon={<CiUser className="text-5xl" />} name="Cliente2" />
                        <Card icon={<CiUser className="text-5xl" />} name="Cliente3" />
                    </CardContainer>

                    <CardContainer title="Productos Principales">
                        <Card icon={<CiShoppingCart className="text-5xl" />} name="Producto1" />
                        <Card icon={<CiShoppingCart className="text-5xl" />} name="Producto2" />
                        <Card icon={<CiShoppingCart className="text-5xl" />} name="Producto3" />
                    </CardContainer>
                </div>
            </section>

            <footer className="bg-contrast shadow-xl rounded-xl flex gap-2 justify-center p-2">
                <div className="flex items-center justify-center basis-20 opacity-50">
                    <PiBuildingApartmentThin className="text-5xl" />
                </div>
                <div className="flex flex-col justify-center basis-60 opacity-50">
                    <div className="grid grid-cols-2">
                        <strong><h2>Nombre: </h2></strong> <h2>Sucursal</h2>
                        <strong><h2>Direccioon: </h2></strong> <h2>xxx-xxx-xxx</h2>
                        <strong><h2>Telefono: </h2></strong> <h2>xxx-xxx-xxx</h2>
                        <strong><h2>Correo: </h2></strong> <h2>xxxx@xxxx.com</h2>
                    </div>

                </div>
            </footer>
        </main>
    )
}
