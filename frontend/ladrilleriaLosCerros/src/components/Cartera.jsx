
import { MdDownload, MdSearch } from "react-icons/md";


export const Cartera = () => {
    const data = [
        {
            cliente: "992782",
            prefijo: "ABC",
            documento: "12345",
            estado: "Pendiente",
            saldoPendiente: "$500",
            fechaVencimiento: "12/10/2024",
            fechaCalculo: "05/10/2024",
            valorFactura: "$1,000",
            totalAbonado: "$500",
            planPago: "Mensual",
            numeroCuotas: 2,
            valorPorCuota: "$250",
        },
        {
            cliente: "878292",
            prefijo: "DEF",
            documento: "67890",
            estado: "Pagado",
            saldoPendiente: "$0",
            fechaVencimiento: "10/08/2024",
            fechaCalculo: "05/08/2024",
            valorFactura: "$1,200",
            totalAbonado: "$1,200",
            planPago: "Semanal",
            numeroCuotas: 3,
            valorPorCuota: "$400",
        },
        {
            cliente: "839939",
            prefijo: "APP",
            documento: "89738",
            estado: "Vencido",
            saldoPendiente: "$900",
            fechaVencimiento: "01/08/2024",
            fechaCalculo: "05/08/2024",
            valorFactura: "$1,200",
            totalAbonado: "$300",
            planPago: "Quincenal",
            numeroCuotas: 3,
            valorPorCuota: "$200",
        },
        // Por si se quieren añadir mas de esta mierda
    ];
    return (
        <div className="grid gap-2 mx-2 mt-2 bg-background">
            <div className="flex gap-4 mb-2 p-2 bg-contrast shadow-lg items-center font-Montserrat rounded-xl">
                <div className="flex-1 flex items-center">
                    <input
                        type="text"
                        placeholder="Buscar"
                        className="border p-1 rounded-xl focus:border-themePage ring-0"
                    />
                    <button className="bg-themePage text-white p-2 rounded-xl ml-2">
                        <MdSearch />
                    </button>
                </div>

                <select className="flex-1 border p-2 rounded-xl focus:border-themePage">
                    <option>Seleccionar Cliente</option>
                    <option>992782</option>
                    <option>878292</option>
                </select>

                <select className="flex-1 border p-2 rounded-xl focus:border-themePage">
                    <option value="estado">Filtrar por</option>
                    <option value="estado">Estado</option>
                    <option value="fechaVencimiento">Fecha de Vencimiento</option>
                    <option value="fechaCalculo">Fecha de Cálculo</option>
                    <option value="valorFactura">Valor de la Factura</option>
                    <option value="totalAbonado">Total Abonado</option>
                    <option value="planPago">Plan de Pago</option>
                    <option value="numeroCuotas">Número de Cuotas</option>
                    <option value="valorPorCuota">Valor por Cuota</option>
                </select>
            </div>

            <div className="overflow-x-auto rounded-xl shadow-lg">
                <table className="min-w-full bg-contrast border rounded-xl font-lato">
                    <thead>
                        <tr className="bg-themePage/95 text-white tex-center">
                            <th className="px-2 py-2">Cliente</th>
                            <th className="px-2 py-2">Prefijo</th>
                            <th className="px-2 py-2">Documento</th>
                            <th className="px-2 py-2">Estado</th>
                            <th className="px-2 py-2">Saldo Pendiente</th>
                            <th className="px-2 py-2">Fecha de Vencimiento</th>
                            <th className="px-2 py-2">Fecha de Cálculo</th>
                            <th className="px-2 py-2">Valor de la Factura</th>
                            <th className="px-2 py-2">Total Abonado</th>
                            <th className="px-2 py-2">Plan de Pago</th>
                            <th className="px-2 py-2">Número de Cuotas</th>
                            <th className="px-2 py-2">Valor por Cuota</th>
                            <th className="px-2 py-2">Descargar Factura</th>
                        </tr>
                    </thead>
                    <tbody>
                        {data.map((item, index) => (
                            <tr key={index} className="border-b text-center">
                                <td className="px-2 py-2">{item.cliente}</td>
                                <td className="px-2 py-2">{item.prefijo}</td>
                                <td className="px-2 py-2">{item.documento}</td>
                                <td className="px-2 py-2">{item.estado}</td>
                                <td className="px-2 py-2">{item.saldoPendiente}</td>
                                <td className="px-2 py-2">{item.fechaVencimiento}</td>
                                <td className="px-2 py-2">{item.fechaCalculo}</td>
                                <td className="px-2 py-2">{item.valorFactura}</td>
                                <td className="px-2 py-2">{item.totalAbonado}</td>
                                <td className="px-2 py-2">{item.planPago}</td>
                                <td className="px-2 py-2">{item.numeroCuotas}</td>
                                <td className="px-2 py-2">{item.valorPorCuota}</td>

                                <td className="px-4 py-2">
                                    <button className="bg-themePage text-white p-1 rounded">
                                        <MdDownload className="mx-auto" />
                                    </button>
                                </td>
                            </tr>
                        ))}
                    </tbody>

                </table>
            </div>
        </div>
    );

}

