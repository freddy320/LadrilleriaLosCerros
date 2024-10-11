import { CiBadgeDollar, CiShoppingCart, CiCalculator1 } from "react-icons/ci";
import { Children } from "react";
import { Line } from "react-chartjs-2"
import { Chart as ChartJs, CategoryScale, LinearScale, PointElement, LineElement, Tooltip, Legend, Title } from "chart.js";
import Filtros from "./panel/Filtros";
ChartJs.register(CategoryScale, LinearScale, PointElement, LineElement, Tooltip, Legend, Title);


const CardContainer = ({ children }) => {
    return (
        <div className="grid grid-cols-3 grid-cols-gridGraficts h-28">
            {children}
        </div>
    )
}






const lineCharData = {
    labels: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio'],
    datasets: [
        {

            label: 'Numero de ventas',
            data: [12, 19, 3, 5, 2, 3, 10],
            borderColor: "#EA8373",
        },

    ],
}


const LineChart = () => {
    return (
        <div className="bg-contrast p-4 rounded-xl shadow-lg">
            <Line data={lineCharData} />
        </div>
    )
}

const ItemPanel = ({ title, resultText, result, icon }) => {
    return (
        <div className='flex gap-2 items-center'>
            <div className={`w-20 h-20 rounded-full flex items-center justify-center bg-themePage text-contrast`}>
                {icon}
            </div>
            <div>
                <h5 className="text-lg opacity-65">{title}</h5>
                <h2 className="text-3xl font-extrabold px-1">{result}</h2>
                <h6 className="text-sm opacity-65 font-bold">{resultText}</h6>
            </div>
        </div>
    )
}

export default function Panel() {
    return (
        <div className="flex h-full gap-4">
            {/* Middle section (KPIs and Charts) */}
            <div className="flex flex-col gap-4 w-4/5">
                {/* KPIs section */}
                <section className='flex gap-8 justify-center bg-contrast p-4 rounded-xl shadow-lg'>
                    <ItemPanel title="Ganancias" resultText="$50 en el último mes" result="$ 1000" icon={<CiBadgeDollar className="w-12 h-12" />} />
                    <ItemPanel title="Promedio" resultText="+ 1.5 de ventas en el último mes" result="50.5" icon={<CiCalculator1 className="w-12 h-12" />} />
                    <ItemPanel title="Ventas" resultText="+ 50 ventas en el último mes" result="1000" icon={<CiShoppingCart className="w-12 h-12" />} />
                </section>

                {/* Charts section */}
                <section className='grid grid-cols-2 gap-2'>
                    {/* Sales Report Chart */}
                    <div className='bg-contrast px-5 py-2 rounded-xl shadow-lg'>
                        <header className="flex justify-between items-baseline">
                            <h2 className="font-extrabold text-xl">Informe general de ventas</h2>
                        </header>
                        <div>
                            <LineChart />
                        </div>
                    </div>

                    {/* Clients Chart */}
                    <div className='bg-contrast px-5 py-2 rounded-xl shadow-lg'>
                        <h2 className="font-semibold text-xl">Clientes</h2>
                        {/* Additional chart or content for Clients */}
                    </div>
                </section>
            </div>

            {/* Right side (Filters) */}
            <section className="w-1/5 bg-contrast p-4 rounded-xl shadow-lg">
            <h3 className="font-bold text-base">Filtros</h3>
                <Filtros />
            </section>
        </div>


    )
}
