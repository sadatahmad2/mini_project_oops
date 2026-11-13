import { ShaderAnimation } from "@/components/ui/shader-animation";

export default function DemoOne() {
  return (
    <div className="relative flex h-[650px] w-full flex-col items-center justify-center overflow-hidden rounded-xl border bg-black">
      <ShaderAnimation />
      <div className="absolute pointer-events-none z-10 flex flex-col items-center justify-center text-center">
        <span className="text-7xl font-extrabold tracking-tight whitespace-pre-wrap text-white drop-shadow-[0_0_35px_rgba(216,238,142,0.6)]">
          VoltEdge
        </span>
        <span className="mt-3 text-sm font-medium tracking-widest uppercase text-slate-300 opacity-80">
          Smart Electricity Management & Billing
        </span>
      </div>
    </div>
  );
}
