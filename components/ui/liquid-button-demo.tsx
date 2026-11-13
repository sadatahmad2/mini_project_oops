import { LiquidButton, MetalButton } from "@/components/ui/liquid-glass-button";

export default function LiquidButtonDemo() {
  return (
    <div className="flex min-h-[300px] flex-col items-center justify-center gap-6 p-8 bg-[#0b1426]">
      <LiquidButton variant="default" size="xxl">
        ⚡ Generate Bill (Liquid Glass)
      </LiquidButton>

      <div className="flex gap-4">
        <MetalButton variant="primary">Primary Metal</MetalButton>
        <MetalButton variant="gold">Gold Metal</MetalButton>
        <MetalButton variant="success">🖨️ Print Receipt</MetalButton>
      </div>
    </div>
  );
}

